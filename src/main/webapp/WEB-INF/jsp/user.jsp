<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>    

    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
    <script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>

    <title>JSP Title</title>    

    <script>

        $(function() {

            const grid = new tui.Grid({
                el: document.getElementById('grid'),                
                data: {
                    initialRequest: true,                    
                    contentType: 'application/json',                    
                    api: {
                        readData: { url: '/grid/user', method: 'GET' },
                        updateData: { url: '/grid/user', method: 'PUT' },
                        deleteData: { url: '/grid/user', method: 'DELETE' }
                    }
                },                                
                scrollX: false,
                scrollY: false,
                minBodyHeight: 30,
                rowHeaders: ['rowNum'],                
                columns: [
                    {
                        header: '아이디',
                        name: 'ID',
                        editor: 'text'
                    },
                    {
                        header: '이름',
                        name: 'NAME',
                        editor: 'text'
                    },
                    {
                        header: '이메일',
                        name: 'EMAIL',
                        editor: 'text'
                    }
                ]
            });

            $('#btn_search').click(function() {
                grid.readData(1, {});
            });

            $('#btn_save').click(function() {                
                grid.request('modifyData', {url: '/grid/modifyUser', method: 'PUT'});   // modifyData는 request에 url 및 method를 추가해 주어야 한다.
            });

            $('#btn_delRow').click(function() {                
                grid.removeRow(grid.getFocusedCell().rowKey);                
            });

            $('#btn_addRow').click(function() {
                grid.appendRow();
            });
            
        });
    </script>
    
</head>
<body>
    <h1>Main Jsp Page TuiGrid</h1>

    <Button type="button" id="btn_search">조회</Button>
    <Button type="button" id="btn_save">저장</Button>
    
    <div id="grid"></div>

    <Button type="button" id="btn_addRow">행추가</Button>
    <Button type="button" id="btn_delRow">행삭제</Button>

</body>
</html>