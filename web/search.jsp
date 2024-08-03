<%@ page import="java.util.Calendar" %>
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

    function validatePassword() {
        var staffCode = document.getElementById('staffCode').value;
        var password = document.getElementById('password').value;
        if (password.length < 8) {
            alert('新密码必须至少8位');
            return false;
        }
        if (staffCode.length === 8) {
            alert('请输入用户编码');
            return false;
        }

        return true;
    }


    $(document).ready(function () {
        $('#searchForm').on('submit', function (e) {
            e.preventDefault(); // 阻止表单默认提交行为

            var submitButton = document.getElementById('submitButton');
            submitButton.value = '查询中...';
            submitButton.classList.add('loading');
            if (!validatePassword()) {
                return false;
            }

            var year = document.getElementById('year').value;
            var month = document.getElementById('month').value;
            var staffCode = document.getElementById('staffCode').value;
            var password = document.getElementById('password').value;

            // 创建一个新的 FormData 对象
            var formData = new FormData();

            // 添加数据到 FormData 对象
            formData.append('year', year);
            formData.append('month', month);
            formData.append('staffCode', staffCode);
            formData.append('password', password);

            $.ajax({
                url: 'salarySearch',
                type: 'POST',
                data: formData,
                contentType: false,
                processData: false,
                success: function (response) {
                    submitButton.value = '查询';
                    submitButton.classList.remove('loading');
                    $('#content').html(response);
                },
                error: function (xhr, status, error) {
                    submitButton.value = '查询';
                    submitButton.classList.remove('loading');
                    // 处理错误
                    alert('查询失败');
                }
            });
            return false; // 阻止表单默认提交行为
        });
    });
</script>
<div class="container">
    <h2>工资查询</h2>

    <form id="searchForm" enctype="application/x-www-form-urlencoded">
        <div class="form-group">
            <label for="staffCode">用户编码:</label>
            <input type="text" id="staffCode" name="staffCode" required>
        </div>
        <div class="form-group">
            <label for="password">密码:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="year">年份:</label>
            <select id="year" name="year" required>
                <%
                    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                    for (int i = 0; i < 5; i++) {
                        out.println("<option value=\"" + (currentYear - i) + "\">" + (currentYear - i) + "</option>");
                    }
                %>
            </select>
        </div>
        <div class="form-group">
            <label for="month">月份:</label>
            <select id="month" name="month" required>
                <%
                    for (int i = 1; i <= 12; i++) {
                        String month = String.format("%02d", i);
                        out.println("<option value=\"" + month + "\">" + month + "</option>");
                    }
                %>
            </select>
        </div>
        <div class="form-group">
            <input type="submit" id="submitButton" value="查询">
        </div>
        <div class="form-group"><span id="error" style="color:red;">${error}</span></div>
    </form>
</div>
