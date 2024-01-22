package com.java.hib;
 
import java.util.List;
import java.util.Map;

import javax.faces.component.UICommand;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
 
public class JsfPaginationBeanJ {
 
	private static final long serialVersionUID = 1L;
	private List<ProviderJ> cdList;
	private ProviderDAOImplJ queryHelper;
	
	/**
	 * pagination stuff
	 */
	
	static private int totalRows;
	static private int firstRow;
	static private int rowsPerPage;
	static private int totalPages;
	private int pageRange;
	private Integer[] pages;
	private int currentPage;
	/**
	 * Creates a new instance of JsfPaginationBean
	 */
	public JsfPaginationBeanJ() {
		queryHelper = new ProviderDAOImplJ();
		/**
		 * the below function should not be called in real world application
		 */
		// Set default values somehow (properties files?).
		rowsPerPage = 5; // Default rows per page (max amount of rows to be displayed at once).
		pageRange = 10; // Default page range (max amount of page links to be displayed at once).
	}
	public List<ProviderJ> getProviderList(ProviderJ provider) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("provider",provider);
		cdList=null;
		if (cdList == null) {
			loadProvider(provider);
		}
		if(cdList!=null && cdList.size()!=0) {
			sessionMap.put("notFoundErr", " ");	
			return cdList;
		}else {
			sessionMap.put("notFoundErr", "Record Not Found");
			return null;
		}	}
	public void setCdList(List<ProviderJ> cdList) {
		this.cdList = cdList;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getFirstRow() {
		return firstRow;
	}
	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}
	public int getRowsPerPage() {
		return rowsPerPage;
	}
	public void setRowsPerPage(int rowsPerPage) {
		JsfPaginationBeanJ.rowsPerPage = rowsPerPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getPageRange() {
		return pageRange;
	}
	public void setPageRange(int pageRange) {
		this.pageRange = pageRange;
	}
	public Integer[] getPages() {
		return pages;
	}
	public void setPages(Integer[] pages) {
		this.pages = pages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	private void loadProvider(ProviderJ provider) {
		System.out.println("First Row  " +firstRow);
		System.out.println("Count  " +rowsPerPage);
		cdList = queryHelper.searchProviders(firstRow, rowsPerPage,provider);
		System.out.println("Employ Count is  " +cdList);
		totalRows = queryHelper.countRows(provider);
		System.out.println("Total Rows  " +totalRows);
		// Set currentPage, totalPages and pages.
		currentPage = (totalRows / rowsPerPage) - ((totalRows - firstRow) / rowsPerPage) + 1;
		totalPages = (totalRows / rowsPerPage) + ((totalRows % rowsPerPage != 0) ? 1 : 0);
		int pagesLength = Math.min(pageRange, totalPages);
		pages = new Integer[pagesLength];
		// firstPage must be greater than 0 and lesser than totalPages-pageLength.
		int firstPage = Math.min(Math.max(0, currentPage - (pageRange / 2)), totalPages - pagesLength);
		// Create pages (page numbers for page links).
		for (int i = 0; i < pagesLength; i++) {
			pages[i] = ++firstPage;
		}
	}
	// Paging actions
	// -----------------------------------------------------------------------------
	public void pageFirst() {
		page(0);
	}
	public void pageNext() {
		page(firstRow + rowsPerPage);
	}
	public void pagePrevious() {
		page(firstRow - rowsPerPage);
	}
	public void pageLast() {
		page(totalRows - ((totalRows % rowsPerPage != 0) ? totalRows % rowsPerPage : rowsPerPage));
	}
	public void page(ActionEvent event) {
		page(((Integer) ((UICommand) event.getComponent()).getValue() - 1) * rowsPerPage);
	}
	private void page(int firstRow) {

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		this.firstRow = firstRow;

		ProviderJ provider = (ProviderJ)sessionMap.get("provider");


		loadProvider(provider);
	}
}