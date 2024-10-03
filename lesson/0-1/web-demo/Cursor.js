document.getElementById('categoryForm').addEventListener('submit', function(event) {
    event.preventDefault();
    addCategory();
    document.getElementById('addCategoryModal').style.display = 'none';
});

function addCategory() {
    const formData = {
        name: document.getElementById('name').value,
        level: parseInt(document.getElementById('level').value),
        parentId: parseInt(document.getElementById('parentId').value),
        path: document.getElementById('path').value,
        status: parseInt(document.getElementById('status').value),
        sort: parseInt(document.getElementById('sort').value),
        remarks: document.getElementById('remarks').value
    };
    fetch('http://127.0.0.1:8099/categories', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
        // 清空输入框
        document.getElementById('categoryForm').reset();
        // 刷新列表
        loadCategories();
    })
    .catch(error => console.error('Error:', error));
}

function search2() {
    const id = document.getElementById('searchId').value;
    const name = document.getElementById('searchName').value;
    fetch(`http://127.0.0.1:8099/categories/search?id=${id}&name=${name}`, {
        method: 'GET'
    })
    .then(response => response.json())
    .then(data => {
        displayCategories(data);
    })
    .catch(error => console.error('Error:', error));
}

function loadCategories() {
    fetch('http://127.0.0.1:8099/categories', {
        method: 'GET'
    })
    .then(response => response.json())
    .then(data => {
        displayCategories(data);
    })
    .catch(error => console.error('Error:', error));
}

function displayCategories(categories) {
    const tbody = document.getElementById('categoryTableBody');
    tbody.innerHTML = '';
    categories.forEach(category => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td>${category.level}</td>
            <td>${category.status === 1 ? '启用' : '禁用'}</td>
            <td>
                <button onclick="editCategory(${category.id})">编辑</button>
                <button onclick="deleteCategory(${category.id})">删除</button>
            </td>
        `;
        tbody.appendChild(row);
    });
}

function editCategory(id) {
    fetch(`http://127.0.0.1:8099/categories/${id}`, {
        method: 'GET'
    })
    .then(response => response.json())
    .then(data => {
        //编辑是一个新的弹出层页面，编程类目数据，关闭弹出层，刷新列表页面
        // 创建一个弹出层
        const modal = document.createElement('div');

        modal.style.display = 'block';
        modal.style.position = 'fixed';
        modal.style.top = '50%';
        modal.style.left = '50%';
        modal.style.transform = 'translate(-50%, -50%)';
        modal.style.backgroundColor = 'white';  
        modal.style.padding = '20px';
        modal.style.border = '1px solid #000';
        modal.innerHTML = `
            <h2>编辑类目</h2>
            <form id="editCategoryForm">
                <input type="hidden" id="id" name="id" value="${data.id}">
                <div>
                    <label for="name">名称:</label>
                    <input type="text" id="name" name="name" value="${data.name}">
                </div>
                <div>
                    <label for="level">级别:</label>
                    <input type="number" id="level" name="level" value="${data.level}">
                </div>
                <div>
                    <label for="parentId">父级ID:</label>
                    <input type="number" id="parentId" name="parentId" value="${data.parentId}">
                </div>
                <div>
                    <label for="path">路径:</label>
                    <input type="text" id="path" name="path" value="${data.path}">
                </div>
                <div>
                    <label for="status">状态:</label>
                    <select id="status" name="status">
                        <option value="1" ${data.status === 1 ? 'selected' : ''}>启用</option>
                        <option value="0" ${data.status === 0 ? 'selected' : ''}>禁用</option>
                    </select>
                </div>
                <div>
                    <label for="sort">排序:</label>
                    <input type="number" id="sort" name="sort" value="${data.sort}">
                </div>
                <div>
                    <label for="remarks">备注:</label>
                    <textarea id="remarks" name="remarks">${data.remarks}</textarea>
                </div>
                <button type="submit">保存</button>
            </form>
        `;
        document.body.appendChild(modal);

        // 保存按钮
        modal.querySelector('#editCategoryForm').onsubmit = function(event) {
            event.preventDefault(); 
            updateCategory2(this);
            document.body.removeChild(modal);
        };
    })
    .catch(error => console.error('Error:', error));

}

function updateCategory2(obj) {
    const formData = {
        id: obj.querySelector('#id').value,   
        name: obj.querySelector('#name').value,
        level: obj.querySelector('#level').value,
        parentId: obj.querySelector('#parentId').value,
        path: obj.querySelector('#path').value,
        status: obj.querySelector('#status').value,
        sort: obj.querySelector('#sort').value,
        remarks: obj.querySelector('#remarks').value
    };
    fetch(`http://127.0.0.1:8099/categories`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    })
    .then(response => response.json())
    .then(data => { 
        console.log(data);
        // 刷新列表
        loadCategories();
    })
    .catch(error => console.error('Error:', error));
}

function deleteCategory(id) {
    if (confirm('确定删除吗？')) {
        fetch(`http://127.0.0.1:8099/categories/${id}`, {
            method: 'DELETE'
        })
        .then(response => response.json())
        .then(data => {
            console.log(data);
            // 刷新列表
            loadCategories();
        })
        .catch(error => console.error('Error:', error));
    }
}

// 打开添加类目弹出层
document.getElementById('openAddCategoryModal').addEventListener('click', function() {
    document.getElementById('addCategoryModal').style.display = 'block';
});

// 关闭添加类目弹出层
document.getElementById('closeAddCategoryModal').addEventListener('click', function() {
    document.getElementById('addCategoryModal').style.display = 'none';
});

// 初始化加载所有类别
loadCategories();
