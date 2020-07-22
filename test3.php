<?php

	
    $conn= new mysqli("localhost","sharnitc_nahid","nahid)98","sharnitc_up");

   	$signup_id=$_POST['signup_id'];
        $post_data = $_POST['post_data'];
        $response = array();
        
                 
	$qry="SELECT * FROM destressit_signup WHERE signup_id=$signup_id";
	
	$result = mysqli_query($qry);
	$num_rows = mysqli_num_rows($result);
	if($num_rows > 0){
        	mysqli_query("INSERT INTO destressit_newsfeed (signup_id, post_data) VALUES('".$signup_id."','".$post_data."')");
        	
	}
	else{
        echo "hoinai";
	}
      
        
 echo json_encode($response);