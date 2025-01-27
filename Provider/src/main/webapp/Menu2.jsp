<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- CSS -->
    <link rel="stylesheet" href="StyleMain.css">
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    
     <style>
        /* Add this CSS for dropdown menu */
            #header{
            	box-shadow: 0px 4px 14px 0px rgba(0, 0, 0, 0.05);
                color: white;
                text-align: center;
                padding: 10px;
                display:flex;
                flex-direction: row;
                justify-content: space-between;
                padding-top: 0px;
                padding-bottom: 0px;
                background-color: #FFFFFF;
                align-items: center;
                
                      }
                      #header, h2{
                      margin: 0px;
                      }
        .nav-links .dropdown:hover .dropdown-content {
             display: block;
            text-align: right;
        }
 
        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }
 
        .dropdown-content a {
            color: black;
            padding: 1px 16px;
            text-decoration: none;
             display: block;
        }
 
        .dropdown-content a:hover {
            background-color: #f1f1f1;
        }
    </style>
     
 
    <title>Admin Dashboard Panel</title>
</head>
<body>
    <nav>
        <div class="logo-name">
            <div class="logo-image">
                <img src="profile.jpg" alt="">
            </div>
            <span class="logo_name">Dr. Abhishek</span>
        </div>
 
        <div class="menu-items">
            <ul class="nav-links">
                <li><a href="#">
                    <i class="uil uil-estate"></i>
                    <span class="link-name">Dashboard</span>
                </a></li>
                <!-- Appointments dropdown -->
                <li class="dropdown">
                    <a href="#">
                        <i class="uil uil-files-landscapes"></i>
                        <span class="link-name">Member</span>
                    </a>
                    <div class="dropdown-content">
                        <!-- Add more items as needed -->
                        <a href="#">Member Details</a>
            			<a href="#">Member Search</a>
            
                    </div>
                </li>
                <li class="dropdown">
                <a href="#">
                    <i class="uil uil-chart"></i>
                    <span class="link-name">Patient</span>
                </a>
                <div class="dropdown-content">
                <a href="#">View Patients</a>
            <a href="">Patient Medical History</a>
                </div>
                </li>
                <li class="dropdown">
                <a href="#">
                    <i class="uil uil-thumbs-up"></i>
                    <span class="link-name">Provider</span>
                </a>
                <div class="dropdown-content">
                <a href="ShowProviderPagination.jsf">Provider Review </a>
                <a href="#">Provider Search </a>
                <a href="#">Update Provider Details</a>
                </div>
                </li>
                <li class="dropdown">
                <a href="#">
                    <i class="uil uil-chart"></i>
                    <span class="link-name">Insurance</span>
                </a>
                <div class="dropdown-content">
                <a href="#">View Insurance</a>
            <a href="NewSearch.jsf">Search Claim</a>
            <a href="">Search Claim History</a>
                </div>
                </li>
                <li><a href="#">
                    <i class="uil uil-comments"></i>
                    <span class="link-name">Pharmacy</span>
                </a></li>
               
            </ul>
            <ul class="logout-mode">
                <li><a href="#">
                    <i class="uil uil-signout"></i>
                    <span class="link-name">Logout</span>
                </a></li>
                <li class="mode">
                    <a href="#">
                        <i class="uil uil-moon"></i>
                        <span class="link-name">Dark Mode</span>
                    </a>
                    <div class="mode-toggle">
                        <span class="switch"></span>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
 
    <section class="dashboard">
        <div class="top">
            <i class="uil uil-bars sidebar-toggle"></i>
            <!-- <div class="search-box">
                <i class="uil uil-search"></i>
                <input type="text" placeholder="Search here...">
            </div> -->
            <!-- <img src="profile.jpg" alt=""> -->
             <div id="header">
        <div style="display: flex; flex-direction: row-reverse; row; gap:20px;">
      <!--   <a href="/" style="text-decoration: none;"><p style="font-size: 18px; font-weight: 600; color:#333333; font-family: sans-serif; cursor: pointer;">Home</p></a> -->
         <p style="font-size: 18px; font-weight: 600; color:#333333; font-family: sans-serif;">Contact Us</p>
         <p style="font-size: 18px; font-weight: 600; color:#333333; font-family: sans-serif;">Login</p>
          <a href="About.jsf" style="text-decoration: none;">
                <p style="font-size: 18px; font-weight: 600; color:#333333; font-family: sans-serif;">About Us</p>
            </a> 
         <a href="Menu.jsp" style="text-decoration: none;">
            <p style="font-size: 18px; font-weight: 600; color:#333333; font-family: sans-serif; cursor: pointer;">Home</p>
        </a>             
        </div>
        </div>
        </div>
 
        <div class="dash-content">
            <div class="overview">
                <div class="title">
                    <i class="uil uil-tachometer-fast-alt"></i>
                    <span class="text">Dashboard</span>
                </div>
                <div class="boxes">
                    <div class="box box1">
                        <i class="uil uil-thumbs-up"></i>
                        <span class="text">Patient Attended</span>
                        <span class="number">3000</span>
                    </div>
                   
                    <!-- Add more boxes as needed -->
                    <div class="box box2">
                        <i class="uil uil-comments"></i>
                        <span class="text">Appointments Today</span>
                        <span class="number">50</span>
                    </div>
                    <div class="box box3">
                        <i class="uil uil-share"></i>
                        <span class="text">Appointments Tommorow</span>
                        <span class="number">45</span>
                    </div>
                </div>
            </div>
 
             <div class="activity">
                <div class="title">
                    <i class="uil uil-clock-three"></i>
                    <span class="text">Hospital Members</span>
                </div>
 
                <div class="activity-data">
                    <div class="data names">
                    <img src="Dr.PNG" style="width:300px; height:200px">
                    
                    <span class="data-list">Name: Piyush</span>
                    <span class="data-list">Address: Bihar</span>
                 
                    </div>
                
                    <div class="data email">
                     <img src="Dr2.PNG" style="width:300px; height:200px">
                    
                    <span class="data-list">Name: Himanshu</span>
                    <span class="data-list">Address: Odisha</span>
                    </div>
                      <div class="data email2">
                     <img src="Dr3.PNG" style="width:300px; height:200px">
                    
                    <span class="data-list">Name: Harsh</span>
                    <span class="data-list">Address: Bihar</span>
                    </div>
                    <!-- <div class="data joined">
                        <span class="data-title">Admitted</span>
                        <span class="data-list">2022-02-12</span>
                        <span class="data-list">2022-02-12</span>
                        <span class="data-list">2022-02-13</span>
                        <span class="data-list">2022-02-13</span>
                        <span class="data-list">2022-02-14</span>
                        <span class="data-list">2022-02-14</span>
                        <span class="data-list">2022-02-15</span>
                    </div>
                    <div class="data type">
                        <span class="data-title">Type</span>
                        <span class="data-list">New</span>
                        <span class="data-list">Member</span>
                        <span class="data-list">Member</span>
                        <span class="data-list">New</span>
                        <span class="data-list">Member</span>
                        <span class="data-list">New</span>
                        <span class="data-list">Member</span>
                    </div>
                    <div class="data status">
                        <span class="data-title">Status</span>
                        <span class="data-list">ICU</span>
                        <span class="data-list">Normal Ward</span>
                        <span class="data-list">Normal Ward</span>
                        <span class="data-list">Normal Ward</span>
                        <span class="data-list">ICU</span>
                        <span class="data-list">Normal Ward</span>
                        <span class="data-list">ICU</span>
                    </div>
                </div> -->
            </div>
        </div> 
    </section>
 
    <script src="script.js"></script>
</body>
</html>