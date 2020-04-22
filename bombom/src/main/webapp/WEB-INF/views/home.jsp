<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=utf-8" %>
<% request.setCharacterEncoding("utf-8"); %>
<% response.setContentType("text/html; charset=utf-8"); %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bombom</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  
  <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900" rel="stylesheet">

  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/open-iconic-bootstrap.min.css">
  
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/animate.css">
  
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/owl.carousel.min.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/owl.theme.default.min.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/magnific-popup.css">

  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/aos.css">

  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/ionicons.min.css">
  
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/flaticon.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/icomoon.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
   <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar ftco-navbar-light site-navbar-target" id="ftco-navbar">
      <div class="container">
         <a class="navbar-brand" href="#"><span>B</span>ombom</a>
         <!--            <button class="navbar-toggler js-fh5co-nav-toggle fh5co-nav-toggle" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="oi oi-menu"></span> Menu
                  </button>  -->
         <table>
            <tbody>
               <tr>
                  <td class="nav-link" style="color: #393939">phone</td>
                  <td>010-xxxx-xxxx</td>
                  <td class="nav-link" style="color: #393939">Email</td>
                  <td>abcde@naver.com</td>
               </tr>
            </tbody>
         </table>
         <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav nav ml-auto">
               <li class="nav-item"><a href="#home-section" class="nav-link"><span>Home</span></a></li>
               <li class="nav-item"><a href="#about-section" class="nav-link"><span>About</span></a></li>
               <li class="nav-item"><a href="#services-section" class="nav-link"><span>Services</span></a></li>
               <li class="nav-item"><a href="#contact-section" class="nav-link"><span>Contact</span></a></li>
            </ul>
         </div>
      </div>
   </nav>
   <section class="hero-wrap js-fullheight">
      <div class="overlay"></div>
      <!-- container(메인페이지 소개) -->
      <div class="container">
         <div class="row no-gutters slider-text js-fullheight justify-content-center align-items-center">
            <div class="col-lg-8 col-md-6 ftco-animate d-flex align-items-center">
                <div class="text text-center">
                  <span class="subheading">Hey! I am</span>
                  <h1>Bombom</h1>
                  <h2>
                    <span
                       class="txt-rotate"
                       data-period="1000"
                       data-rotate='[ "Now,", "Let me", "introduce myself" ]'></span>
                  </h2>
               </div>
            </div>
         </div>
        </div>
        <!-- //container -->
        <div class="mouse">
         <a href="#" class="mouse-icon">
            <div class="mouse-wheel"><span class="ion-ios-arrow-round-down"></span></div>
         </a>
        </div>
    </section>

   <section class="ftco-about img ftco-section ftco-no-pt ftco-no-pb" id="about-section">
      <div class="container">
         <div class="row d-flex no-gutters">
            <!-- 이미지  or 영상 -->
            <div class="col-md-6 col-lg-6 d-flex">
               <div class="img-about img d-flex ">
                  <img alt="" src="${pageContext.request.contextPath}/resources/images/person_about.jpeg" width="500" height="500"/>
               </div>
            </div>
         <!-- //이미지 or 영상 -->
            <div class="col-md-6 col-lg-6 pl-md-5 py-5">
               <ul class="nav nav-tabs">
                 <li class="nav-item"><a href="#AboutMe" class="nav-link active" data-toggle="tab"><span>AboutMe</span></a></li>
                 <li class="nav-item"><a href="#Projects" class="nav-link" data-toggle="tab"><span>Projects</span></a></li>
                 <li class="nav-item"><a href="#Skills" class="nav-link" data-toggle="tab"><span>Skills</span></a></li>
                 <li class="nav-item"><a href="#Awards" class="nav-link" data-toggle="tab"><span>Awards</span></a></li>
               </ul>
               <div class="row justify-content-start pb-3">
                  <div class="tab-content" >
                     <!-- AboutMe -->
                        <div class="tab-pane fade show active " id="AboutMe">
                         <!-- <h2 class="mb-4">About Me</h2> -->
                        <br>
                        <ul class="about-info mt-4 px-md-0 px-2">
                           <li class="d-flex"><span>Name:</span> <span>김소현</span></li>
                           <li class="d-flex"><span>Date of birth:</span> <span>1996.03.07</span></li>
                           <li class="d-flex"><span>Address:</span> <span>서울시 마포구 </span></li>
                           <li class="d-flex"><span>Email:</span> <span>shkim9019@naver.com</span></li>
                           <li class="d-flex"><span>Phone: </span> <span>010-xxxx-xxxx</span></li>
                        </ul>
                        </div>
                     <!-- //AboutMe -->
                     
                     <!-- Projects -->
                     <div class="tab-pane fade" id="Projects">
                      <!-- <h2 class="mb-4">Projects</h2> -->
                     <table cellpadding="3">
                        <tbody>
                        	<tr>
                        		<td colspan="3">
                        		<small>이 곳에서는 그동안 배우고 적용한 프로젝트를 볼 수 있는 곳입니다. <br>해당하는 버튼을 클릭하면 소스와,시연영상을 보실 수 있습니다.</small>
                        		</td>
                        	</tr>
                        	<tr>
                        	<td><br/></td>
                        	</tr>
                           <tr>
                              <td><h5 class="text-primary" ><b>1차 프로젝트</b></h5></td>
                           </tr>
                           <tr>
                              <td rowspan="4">
                                  <a href="https://github.com/shkim9019/eHRGit0101">
                                 	<img src="${pageContext.request.contextPath}/resources/images/image_1.jpg" width="170" height="170" align="top">
                                 </a>  
                              </td>
                              <td>
                              	<p><b> 이름:</b></p>
                              </td>
                              <td>
                              	<p> MySportsGround(MSG)</p>
                              </td>
                           </tr>
                           <tr>
                           	  <td>
                           	  	<p><b> 주제:</b></p>
                           	  </td>
                           	  <td>
                           	  	<p> 주제란 이것이다</p>
                           	  </td>
                           </tr>
                           <tr>
                           	  <td>
                           	  	<p><b> 설명:</b></p>
                           	  </td>
                           	  <td>
                           	  	<p> 설명이란 이것이다</p>
                           	  </td>
                           </tr>
                           <tr>
                           	  <td colspan="2" align="center">
                           	      <a href="https://github.com/shkim9019/eHRGit0101/blob/master/eHRGit0101/src/eHRGit0101/HelloWorld.java">
                           	      	<input type="button" class="btn btn-outline-primary" value="소스보기"/>
                           	      </a> &nbsp;&nbsp;
                           	  	  <input type="button" class="btn btn-outline-primary" value="영상보기"/>  
                           	  </td>
                           </tr>
                           <tr>
                        	<td><br/></td>
                        	</tr>
                           <tr>
                              <td><h5 class="text-primary"><b>2차 프로젝트</b></h5></td>
                           </tr>
                           <tr>
                              <td rowspan="4">
                                 <a href="https://github.com/shkim9019/eHRGit0101">
                                 	<img src="${pageContext.request.contextPath}/resources/images/image_1.jpg" width="170" height="170" align="top">
                                 </a>
                              </td>
                              <td>
                              	<p><b> 이름:</b></p>
                              </td>
                              <td>
                              	<p> 숙박의 민족</p>
                              </td>
                           </tr>
                           <tr>
                           	  <td>
                           	  	<p><b> 주제:</b></p>
                           	  </td>
                           	  <td>
                           	  	<p>주제란 이것이다</p>
                           	  </td>
                           </tr>
                           <tr>
                           	  <td>
                           	  	<p><b> 설명:</b></p>
                           	  </td>
                           	  <td>
                           	  	<p> 설명이란 이것이다</p>
                           	  </td>
                           </tr>
                           <tr>
                           	  <td colspan="2" align="center">
                           	      <input type="button" class="btn btn-outline-primary" value="소스보기"/> &nbsp;&nbsp;
                           	  	  <input type="button" class="btn btn-outline-primary" value="영상보기"/>  
                           	  </td>
                           </tr>
                           <tr>
                        	<td><br/></td>
                        	</tr>
                           <tr>
                              <td><h5 class="text-primary"><b>3차 프로젝트</b></h5></td>
                           </tr>
                           <tr>
                              <td rowspan="4">
                                 <a href="https://github.com/shkim9019/eHRGit0101">
                                 	<img src="${pageContext.request.contextPath}/resources/images/image_1.jpg" width="170" height="170" align="top">
                                 </a>
                              </td>
                              <td>
                              	<p><b> 이름:</b></p>
                              </td>
                              <td>
                              	<p> 봄봄 </p>
                              </td>
                           </tr>
                           <tr>
                           	  <td>
                           	  	<p><b> 주제:</b></p>
                           	  </td>
                           	  <td>
                           	  	<p> 주제란 이것이다</p>
                           	  </td>
                           </tr>
                           <tr>
                           	  <td>
                           	  	<p><b> 설명:</b></p>
                           	  </td>
                           	  <td>
                           	  	<p> 설명이란 이것이다</p>
                           	  </td>
                           </tr>
                           <tr>
                           	  <td colspan="2" align="center">
                           	      <input type="button" class="btn btn-outline-primary" value="소스보기"/> &nbsp;&nbsp;
                           	  	  <input type="button" class="btn btn-outline-primary" value="영상보기"/>  
                           	  </td>
                           </tr>
                        </tbody>
                     </table>
                     </div>
                     <!-- //Projects -->
                     
                     <!-- Skills -->
                     <div class="tab-pane fade" id="Skills">
                        <div id="page-3" class= "page three">
                        <!-- <h2 class="mb-4">Skills</h2> -->
                        <br>
                           <div class="row progress-circle mb-5">
                              <div class="col-lg-4 mb-4">
                                 <div class="bg-white rounded-lg shadow p-2">
                                    <h2 class="h5 font-weight-bold text-center mb-4">CSS</h2>
                                    <!-- Progress bar 1 -->
                                    <div class="progress mx-auto" data-value='90'> <!-- data-values값만큼 색칠 -->
                                       <span class="progress-left"> 
                                          <span class="progress-bar border-primary mb-4" ></span>
                                       </span>
                                       <span class="progress-right">
                                          <span class="progress-bar border-primary"></span>
                                       </span>
                                       <div class="progress-value w-100 h-100 rounded-circle d-flex align-items-center justify-content-center">
                                          <div class="h2 font-weight-bold">90<sup class="small">%</sup></div>
                                       </div>
                                    </div>
                                    
                                    <!-- Demo info -->
                                    <div class="row text-center mt-4">
                                       <div class="col-6 border-right">
                                          <div class="h4 font-weight-bold mb-0">28%</div><span class="small text-gray">Last week</span>
                                       </div>
                                       <div class="col-6">
                                          <div class="h4 font-weight-bold mb-0">60%</div><span class="small text-gray">Last month</span>
                                       </div>
                                    </div>
                                 </div>
                              </div>
                                 <div class="col-lg-4 mb-4">
                                    <div class="bg-white rounded-lg shadow p-2">
                                       <h2 class="h5 font-weight-bold text-center mb-4">HTML</h2>
                                       <!-- Progress bar 1 -->
                                       <div class="progress mx-auto" data-value='80'>
                                          <span class="progress-left">
                                             <span class="progress-bar border-primary"></span>
                                          </span>
                                          <span class="progress-right">
                                             <span class="progress-bar border-primary"></span>
                                          </span>
                                          <div class="progress-value w-100 h-100 rounded-circle d-flex align-items-center justify-content-center">
                                             <div class="h2 font-weight-bold">80<sup class="small">%</sup></div>
                                          </div>
                                       </div>
                                       
                                       <!-- Demo info -->
                                       <div class="row text-center mt-4">
                                          <div class="col-6 border-right">
                                              <div class="h4 font-weight-bold mb-0">28%</div><span class="small text-gray">Last week</span>
                                          </div>
                                          <div class="col-6">
                                              <div class="h4 font-weight-bold mb-0">60%</div><span class="small text-gray">Last month</span>
                                          </div>
                                       </div>
                                    </div>
                                 </div>
                                 <div class="col-lg-4 mb-4">
                                    <div class="bg-white rounded-lg shadow p-2">
                                       <h2 class="h5 font-weight-bold text-center mb-4">jQuery</h2>
                                       <!-- Progress bar 1 -->
                                       <div class="progress mx-auto" data-value='75'>
                                          <span class="progress-left">
                                             <span class="progress-bar border-primary"></span>
                                          </span>
                                          <span class="progress-right">
                                             <span class="progress-bar border-primary"></span>
                                          </span>
                                          <div class="progress-value w-100 h-100 rounded-circle d-flex align-items-center justify-content-center">
                                             <div class="h2 font-weight-bold">75<sup class="small">%</sup></div>
                                          </div>
                                       </div>
                                       <!-- Demo info -->
                                       <div class="row text-center mt-4">
                                          <div class="col-6 border-right">
                                              <div class="h4 font-weight-bold mb-0">28%</div><span class="small text-gray">Last week</span>
                                          </div>
                                          <div class="col-6">
                                              <div class="h4 font-weight-bold mb-0">60%</div><span class="small text-gray">Last month</span>
                                          </div>
                                       </div>
                                    </div>
                                 </div>
                           </div>
                           <div class="row">
                              <div class="col-md-6 animate-box">
                                 <div class="progress-wrap ftco-animate">
                                    <h3>Photoshop</h3>
                                    <div class="progress">
                                        <div class="progress-bar color-1" role="progressbar" aria-valuenow="90"
                                               aria-valuemin="0" aria-valuemax="100" style="width:90%">
                                             <span>90%</span>
                                         </div>
                                    </div>
                                 </div>
                              </div>
                              <div class="col-md-6 animate-box">
                                 <div class="progress-wrap ftco-animate">
                                    <h3>jQuery</h3>
                                    <div class="progress">
                                        <div class="progress-bar color-2" role="progressbar" aria-valuenow="85"
                                             aria-valuemin="0" aria-valuemax="100" style="width:85%">
                                            <span>85%</span>
                                         </div>
                                    </div>
                                 </div>
                              </div>
                              <div class="col-md-6 animate-box">
                                 <div class="progress-wrap ftco-animate">
                                    <h3>HTML5</h3>
                                    <div class="progress">
                                        <div class="progress-bar color-3" role="progressbar" aria-valuenow="95"
                                             aria-valuemin="0" aria-valuemax="100" style="width:95%">
                                               <span>95%</span>
                                         </div>
                                    </div>
                                 </div>
                              </div>
                              <div class="col-md-6 animate-box">
                                 <div class="progress-wrap ftco-animate">
                                    <h3>CSS3</h3>
                                    <div class="progress">
                                        <div class="progress-bar color-4" role="progressbar" aria-valuenow="90"
                                             aria-valuemin="0" aria-valuemax="100" style="width:90%">
                                               <span>90%</span>
                                         </div>
                                    </div>
                                 </div>
                              </div>
                              <div class="col-md-6 animate-box">
                                 <div class="progress-wrap ftco-animate">
                                    <h3>WordPress</h3>
                                    <div class="progress">
                                        <div class="progress-bar color-5" role="progressbar" aria-valuenow="70"
                                             aria-valuemin="0" aria-valuemax="100" style="width:70%">
                                            <span>70%</span>
                                         </div>
                                    </div>
                                 </div>
                              </div>
                              <div class="col-md-6 animate-box">
                                 <div class="progress-wrap ftco-animate">
                                    <h3>SEO</h3>
                                    <div class="progress">
                                        <div class="progress-bar color-6" role="progressbar" aria-valuenow="80"
                                             aria-valuemin="0" aria-valuemax="100" style="width:80%">
                                               <span>80%</span>
                                         </div>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                     <!-- //Skills -->
                     
                     <!--Awards  -->
                     <div class="tab-pane fade" id="Awards">
                        <div id="page-4" class= "page four">
                           <!--  <h2 class="heading">Awards</h2> -->
                           <br>
                           <div class="resume-wrap d-flex ftco-animate">
                              <div class="icon d-flex align-items-center justify-content-center">
                                 <span class="flaticon-ideas"></span>
                              </div>
                              <div class="text pl-3">
                                 <span class="date">2014-2015</span>
                                 <h2>Top 10 Web Developer</h2>
                                 <span class="position">Cambridge University</span>
                                 <p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                              </div>
                           </div>
                           <div class="resume-wrap d-flex ftco-animate">
                              <div class="icon d-flex align-items-center justify-content-center">
                                  <span class="flaticon-ideas"></span>
                               </div>
                               <div class="text pl-3">
                                 <span class="date">2014-2015</span>
                                 <h2>Top 5 LeaderShip Exellence Winner</h2>
                                 <span class="position">Cambridge University</span>
                                 <p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                              </div>
                           </div>
                           <div class="resume-wrap d-flex ftco-animate">
                              <div class="icon d-flex align-items-center justify-content-center">
                                  <span class="flaticon-ideas"></span>
                               </div>
                               <div class="text pl-3">
                                 <span class="date">2014-2015</span>
                                 <h2>Top 4 Web Tester</h2>
                                 <span class="position">Cambridge University</span>
                                 <p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                              </div>
                           </div>
                        </div>
                     </div>
                     <!-- //Awards -->
                  </div><!-- //tab-content -->
               </div>
            </div>
           </div>
      </div><!-- //container -->
   </section>

    <section class="ftco-section ftco-partner">
       <div class="container">
          <div class="row">
             <div class="col-sm ftco-animate">
                <a href="#" class="partner"><img src="resources/images/partner-1.png" class="img-fluid" alt="Colorlib Template"></a>
             </div>
             <div class="col-sm ftco-animate">
                <a href="#" class="partner"><img src="resources/images/partner-2.png" class="img-fluid" alt="Colorlib Template"></a>
             </div>
             <div class="col-sm ftco-animate">
                <a href="#" class="partner"><img src="resources/images/partner-3.png" class="img-fluid" alt="Colorlib Template"></a>
             </div>
             <div class="col-sm ftco-animate">
                <a href="#" class="partner"><img src="resources/images/partner-4.png" class="img-fluid" alt="Colorlib Template"></a>
             </div>
             <div class="col-sm ftco-animate">
                <a href="#" class="partner"><img src="resources/images/partner-5.png" class="img-fluid" alt="Colorlib Template"></a>
             </div>
          </div>
       </div>
    </section>


    <section class="ftco-section" id="services-section">
   <div class="container-fluid px-md-5">
      <div class="row justify-content-center py-5 mt-5">
          <div class="col-md-12 heading-section text-center ftco-animate">
              <h1 class="big big-2">Services</h1>
             <h2 class="mb-4">Services</h2>
             <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia</p>
           </div>
      </div>
         <div class="row">
            <div class="col-md-4 text-center d-flex ftco-animate">
               <a href="#" class="services-1 shadow">
                  <span class="icon">
                     <i class="flaticon-analysis"></i>
                  </span>
                  <div class="desc">
                     <h3 class="mb-5">Web Design</h3>
                     <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                  </div>
               </a>
            </div>
            <div class="col-md-4 text-center d-flex ftco-animate">
               <a href="#" class="services-1 shadow">
                  <span class="icon">
                     <i class="flaticon-flasks"></i>
                  </span>
                  <div class="desc">
                     <h3 class="mb-5">Phtography</h3>
                     <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                  </div>
               </a>
            </div>
            <div class="col-md-4 text-center d-flex ftco-animate">
               <a href="#" class="services-1 shadow">
                  <span class="icon">
                     <i class="flaticon-ideas"></i>
                  </span>
                  <div class="desc">
                     <h3 class="mb-5">Web Developer</h3>
                     <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                  </div>
               </a>
            </div>
            <div class="col-md-4 text-center d-flex ftco-animate">
               <a href="#" class="services-1 shadow">
                  <span class="icon">
                     <i class="flaticon-innovation"></i>
                  </span>
                  <div class="desc">
                     <h3 class="mb-5">App Developing</h3>
                     <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                  </div>
               </a>
            </div>
            <div class="col-md-4 text-center d-flex ftco-animate">
               <a href="#" class="services-1 shadow">
                  <span class="icon">
                     <i class="flaticon-ux-design"></i>
                  </span>
                  <div class="desc">
                     <h3 class="mb-5">Branding</h3>
                     <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                  </div>
               </a>
            </div>
            <div class="col-md-4 text-center d-flex ftco-animate">
               <a href="#" class="services-1 shadow">
                  <span class="icon">
                     <i class="flaticon-idea"></i>
                  </span>
                  <div class="desc">
                     <h3 class="mb-5">Product Strategy</h3>
                     <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                  </div>
               </a>
            </div>
         </div>
      </div>
    </section>
 

    <section class="ftco-section contact-section ftco-no-pb" id="contact-section">
      <div class="container">
         <div class="row justify-content-center mb-5 pb-3">
            <div class="col-md-7 heading-section text-center ftco-animate">
                <h1 class="big big-2">Contact</h1>
                <h2 class="mb-4">Contact Me</h2>
                <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia</p>
            </div>
         </div>
         <div class="row d-flex contact-info mb-5">
            <div class="col-md-6 col-lg-3 d-flex ftco-animate">
               <div class="align-self-stretch box text-center p-4 shadow">
                  <div class="icon d-flex align-items-center justify-content-center">
                     <span class="icon-map-signs"></span>
                  </div>
                  <div>
                     <h3 class="mb-4">Address</h3>
                      <p>198 West 21th Street, Suite 721 New York NY 10016</p>
                  </div>
               </div>
            </div>
            <div class="col-md-6 col-lg-3 d-flex ftco-animate">
               <div class="align-self-stretch box text-center p-4 shadow">
                  <div class="icon d-flex align-items-center justify-content-center">
                     <span class="icon-phone2"></span>
                  </div>
                  <div>
                     <h3 class="mb-4">Contact Number</h3>
                      <p><a href="tel://1234567920">+ 1235 2355 98</a></p>
                  </div>
               </div>
            </div>
            <div class="col-md-6 col-lg-3 d-flex ftco-animate">
               <div class="align-self-stretch box text-center p-4 shadow">
                  <div class="icon d-flex align-items-center justify-content-center">
                     <span class="icon-paper-plane"></span>
                  </div>
                  <div>
                     <h3 class="mb-4">Email Address</h3>
                      <p><a href="mailto:info@yoursite.com">info@yoursite.com</a></p>
                  </div>
               </div>
            </div>
            <div class="col-md-6 col-lg-3 d-flex ftco-animate">
               <div class="align-self-stretch box text-center p-4 shadow">
                  <div class="icon d-flex align-items-center justify-content-center">
                     <span class="icon-globe"></span>
                  </div>
                  <div>
                     <h3 class="mb-4">Website</h3>
                         <p><a href="#">yoursite.com</a></p>
                   </div>
               </div>
            </div>
         </div>
         <div class="row no-gutters block-9">
            <div class="col-md-6 order-md-last d-flex">
               <form action="#" class="bg-light p-4 p-md-5 contact-form">
                  <div class="form-group">
                      <input type="text" class="form-control" placeholder="Your Name">
                  </div>
                  <div class="form-group">
                      <input type="text" class="form-control" placeholder="Your Email">
                  </div>
                  <div class="form-group">
                      <input type="text" class="form-control" placeholder="Subject">
                  </div>
                  <div class="form-group">
                      <textarea name="" id="" cols="30" rows="7" class="form-control" placeholder="Message"></textarea>
                  </div>
                  <div class="form-group">
                      <input type="submit" value="Send Message" class="btn btn-primary py-3 px-5">
                  </div>
               </form>
            </div>
            <div class="col-md-6 d-flex">
               <div class="img-about img d-flex ">
                     <img alt="" src="${pageContext.request.contextPath}/resources/images/about.jpg" width="500" height="500"/>
               </div>
            </div>
          </div>
       </div>
    </section>

    <footer class="ftco-footer ftco-section">
      <div class="container">
         <div class="row mb-5">
            <div class="col-md">
                <div class="ftco-footer-widget mb-4">
                  <h2 class="ftco-heading-2">About</h2>
                  <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                  <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
                    <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                    <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                    <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
                  </ul>
                </div>
              </div>
              <div class="col-md">
                 <div class="ftco-footer-widget mb-4 ml-md-4">
                    <h2 class="ftco-heading-2">Links</h2>
                    <ul class="list-unstyled">
                       <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Home</a></li>
                       <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>About</a></li>
                       <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Services</a></li>
                       <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Projects</a></li>
                       <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Contact</a></li>
                    </ul>
                 </div>
              </div>
              <div class="col-md">
                  <div class="ftco-footer-widget mb-4">
                   <h2 class="ftco-heading-2">Services</h2>
                   <ul class="list-unstyled">
                      <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Web Design</a></li>
                      <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Web Development</a></li>
                      <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Business Strategy</a></li>
                      <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Data Analysis</a></li>
                      <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Graphic Design</a></li>
                   </ul>
                 </div>
              </div>
              <div class="col-md">
                 <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2">Have a Questions?</h2>
                    <div class="block-23 mb-3">
                    <ul>
                       <li><span class="icon icon-map-marker"></span><span class="text">203 Fake St. Mountain View, San Francisco, California, USA</span></li>
                       <li><a href="#"><span class="icon icon-phone"></span><span class="text">+2 392 3929 210</span></a></li>
                       <li><a href="#"><span class="icon icon-envelope"></span><span class="text">info@yourdomain.com</span></a></li>
                     </ul>
                    </div>
                 </div>
              </div>
         </div>
         <div class="row">
            <div class="col-md-12 text-center">
               <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
               Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This project is made with  by <a href="#home_section" target="_blank">Bombom</a>
               <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
            </div>
         </div>
      </div>
    </footer>
    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery-migrate-3.0.1.min.js"/>"></script>
<script src="<c:url value="/resources/js/popper.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.easing.1.3.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.waypoints.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.stellar.min.js"/>"></script>
<script src="<c:url value="/resources/js/owl.carousel.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.magnific-popup.min.js"/>"></script>
<script src="<c:url value="/resources/js/aos.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.animateNumber.min.js"/>"></script>
<script src="<c:url value="/resources/js/scrollax.min.js"/>"></script>
<script src="<c:url value="/resources/js/main.js"/>"></script>
</body>
</html>