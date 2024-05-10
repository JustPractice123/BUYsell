<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        .container {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            margin-top: 50px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
        }

        .profile-info {
            margin-bottom: 20px;
        }

        .profile-info label {
            display: inline-block;
            width: 100px;
        }

        .profile-info span {
            display: inline-block;
            margin-left: 10px;
        }

        .btn-container {
            text-align: center;
        }

        .btn-container button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            font-size: 16px;
        }

        .btn-container button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>User Profile</h2>
    <div class="profile-info">
        <label for="name">Username:</label>
        <span>${user.getName()}</span>
    </div>
    <div class="profile-info">
        <label for="email">Email:</label>
        <span>${user.getEmail()}</span>
    </div>
    <div class="profile-info">
        <label for="phoneNumber">Phone number:</label>
        <span>${user.getPhoneNumber()}</span>
    </div>
    <div class="btn-container">
        <button>Edit Profile</button>
    </div>
</div>
</body>
</html>
