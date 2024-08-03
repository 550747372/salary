<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }

    .container {
        width: 300px;
        margin: 50px auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 5px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    .form-group {
        margin-bottom: 15px;
    }

    .form-group label {
        display: block;
        margin-bottom: 5px;
        color: #333;
    }

    .form-group input {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 3px;
    }

    .form-group input[type="submit"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 3px;
        background-color: #f9f9f9;
        color: #333;
        transition: background-color 0.3s, border-color 0.3s;
    }

    .form-group input[type="submit"] {
        background-color: #5cb85c;
        color: white;
        border: none;
        cursor: pointer;
    }

    .form-group input[type="submit"]:hover {
        background-color: #f0f0f0;
        border-color: #ccc;
    }

    .form-group select {
        width: 100%;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 3px;
        background-color: #f9f9f9;
        color: #333;
        transition: background-color 0.3s, border-color 0.3s;
    }

    .form-group select:hover {
        background-color: #f0f0f0;
        border-color: #ccc;
    }

    .loading {
        position: relative;
        opacity: 0.7;
        pointer-events: none;
    }

    .loading:after {
        content: '';
        position: absolute;
        top: 50%;
        left: 50%;
        width: 20px;
        height: 20px;
        margin-top: -10px;
        margin-left: -10px;
        border: 2px solid #fff;
        border-top-color: #333;
        border-radius: 50%;
        animation: spin 1s linear infinite;
    }

    @keyframes spin {
        0% {
            transform: rotate(0deg);
        }
        100% {
            transform: rotate(360deg);
        }
    }
</style>
<script>

    function isValidPassword(password) {
        // 正则表达式，用于匹配8-16位的数字和字母
        var passwordPattern = /^(?=.*[0-9])(?=.*[a-zA-Z])[a-zA-Z0-9]{8,16}$/;

        // 使用正则表达式测试密码
        return passwordPattern.test(password);
    }

    function validatePassword() {
        var staffCode = document.getElementById('staffCode').value;
        var newPassword = document.getElementById('newPassword').value;
        var confirmPassword = document.getElementById('confirmPassword').value;

        if(!isValidPassword(newPassword)){
            alert('密码必须在8-16位，只包含数字、字母且同时包含数字字母');
            return false;
        }

        if (staffCode == null || staffCode.length === 0) {
            alert('请输入用户编码');
            return false;
        }
        if (newPassword.length < 8 || confirmPassword.length < 8) {
            alert('新密码必须至少8位');
            return false;
        }
        if (newPassword !== confirmPassword) {
            alert('两次输入的新密码不一致');
            return false;
        }
        return true;
    }

    $(document).ready(function () {
        $('#uploadForm').on('submit', function (e) {
            e.preventDefault(); // 阻止表单默认提交行为

            var submitButton = document.getElementById('submitButton');
            submitButton.value = '修改中...';
            submitButton.classList.add('loading');
            if (!validatePassword()) {
                return;
            }

            // 创建一个表单数据对象来存储表单数据和文件
            var formData = new FormData();
            formData.append('staffCode', document.getElementById('staffCode').value);
            formData.append('currentPassword', document.getElementById('currentPassword').value);
            formData.append('newPassword', document.getElementById('newPassword').value);
            formData.append('confirmPassword', document.getElementById('confirmPassword').value);

            $.ajax({
                url: 'changePassword',
                type: 'POST',
                data: formData,
                contentType: false,
                processData: false,
                success: function (response) {
                    submitButton.value = '更新密码';
                    submitButton.classList.remove('loading');
                    $('#content').html(response);
                },
                error: function (xhr, status, error) {
                    submitButton.value = '更新密码';
                    submitButton.classList.remove('loading');
                    alert('系统错误');
                }
            });
        });
    });
</script>
<div class="container">
    <h2>修改密码</h2>

    <form id="uploadForm" enctype="multipart/form-data">
        <div class="form-group">
            <label for="staffCode">用户编码:</label>
            <input type="text" id="staffCode" name="staffCode" required>
        </div>
        <div class="form-group">
            <label for="currentPassword">当前密码:</label>
            <input type="password" id="currentPassword" name="currentPassword" required>
        </div>
        <div class="form-group">
            <label for="newPassword">新密码:</label>
            <input type="password" id="newPassword" name="newPassword" required>
        </div>
        <div class="form-group">
            <label for="confirmPassword">确认新密码:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>
        </div>
        <div class="form-group">
            <input type="submit" id="submitButton" value="修改密码">
        </div>
        <div class="form-group"><span id="error" style="color:red;">${error}</span></div>
    </form>
</div>
