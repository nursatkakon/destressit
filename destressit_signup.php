<?php

	
    $conn= new mysqli("localhost","sharnitc_nahid","nahid)98","sharnitc_up");

   
        $name=$_REQUEST['name'];
	$email=$_REQUEST['email'];
        $password=$_REQUEST['password'];
        $response = array();
        
                 
        $sql= "INSERT INTO destressit_signup (name,email,password) VALUES('".$name."','".$email."','".$password."')";
      // print_r($sql);
        $execute_sql= $conn->query($sql);

if($execute_sql){
	$response['msg']="Data entry successful";
	$response['val']=1;
}
else{
	$response['msg']="Data entry unsuccessful";
	$response['val']=0;
}

       
      
        
 echo json_encode($response);