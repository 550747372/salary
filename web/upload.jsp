<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>文件上传</title>
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

        .form-group input[type="file"],
        .form-group input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 3px;
            background-color: #f9f9f9;
            color: #333;
            transition: background-color 0.3s, border-color 0.3s;
        }

        .form-group input[type="file"]:hover,
        .form-group input[type="submit"]:hover {
            background-color: #f0f0f0;
            border-color: #ccc;
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

        $(document).ready(function () {
            $('#uploadForm').on('submit', function (e) {
                e.preventDefault(); // 阻止表单默认提交行为

                var submitButton = document.getElementById('submitButton');
                submitButton.value = '上传中...';
                submitButton.classList.add('loading');
                var fileInput = $('#file')[0].files[0]; // 获取上传的文件

                // 创建一个表单数据对象来存储表单数据和文件
                var formData = new FormData();
                formData.append('year', document.getElementById('year').value);
                formData.append('month', document.getElementById('month').value);
                formData.append('file', fileInput);

                $.ajax({
                    url: 'processExcel',
                    type: 'POST',
                    data: formData,
                    contentType: false,
                    processData: false,
                    success: function (response) {
                        submitButton.value = '上传文件';
                        submitButton.classList.remove('loading');
                        // 处理响应
                        alert('文件上传成功');
                    },
                    error: function (xhr, status, error) {
                        submitButton.value = '上传文件';
                        submitButton.classList.remove('loading');
                        // 处理错误
                        alert('系统错误，文件上传失败');
                    }

                });
            });
        });
    </script>
</head>
<body>
<div class="container">
    <h2>文件上传</h2>
    <form action="upload.jsp" id="uploadForm" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="file">选择文件:</label>
            <input type="file" id="file" name="file" required>
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
            <input type="submit" id="submitButton" value="上传文件">
        </div>
    </form>
</div>
</body>
</html>