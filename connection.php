<?php

$firstname= $_POST["firstname"];
$lastname= $_POST["lastname"];
$reply;

$conn = mysqli_connect($server, $username, $password);
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}


if ((!empty(firstname))&& (!empty(lastname))){
    $server = "localhost";
    $username = "root";
    $password = "";

    //1 creating database
    $sql = "CREATE DATABASE phpapp1";
    if (mysqli_query($conn, $sql)) {
      
    }else {
        $reply= "Error : " . mysqli_error($conn);
    }

  
    //2 creating table
    $sql2 = "CREATE TABLE users (
    id INT(3) UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
    firstname VARCHAR(30) NOT NULL,
    lastname VARCHAR(30) NOT NULL,
    )";

    if ($conn->query($sql2) === TRUE) {
      
    } else {
        $reply= "Error : " . $conn->error;
    }
  
    //3 inserting data
  
    $sql3 = "INSERT INTO users (firstname, lastname)
    VALUES ('$firstname', '$lastname')";

    if ($conn->query($sql) === TRUE) {
       $reply= $firstname;
    } else {
        $reply= "Error: " . $conn->error;
    }
  
   echo $reply;
}else{
  echo "please fill out the forms";
}



mysqli_close($conn);
?>
