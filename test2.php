<?php
   $con= new mysqli("localhost","sharnitc_nahid","nahid)98","sharnitc_up");

  $response = array();
  
   if (mysqli_connect_errno($con)) {
      echo "Failed to connect to MySQL: " . mysqli_connect_error();
   }

   $username = $_GET['name'];
   $password = $_GET['password'];
   $result = mysqli_query($con,"SELECT * FROM destressit_signup WHERE name='$name' and password='$password'");
   $row = mysqli_fetch_array($result);
   $data = $row[0];

   if($data){
      //echo $data;
       $response['val']=1;
  $response['msg']="Log In successful";
      
   }
   else{
    $response['val']=0;
  $response['msg']="Error";
   }
   mysqli_close($con);
   
echo json_encode($response);