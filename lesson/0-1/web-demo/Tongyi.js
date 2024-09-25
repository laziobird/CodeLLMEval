document.getElementById('categoryForm').addEventListener('submit', function(event) {
    event.preventDefault();
    addCategory();
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

function searchCategories() {
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
        // 显示编辑弹窗或直接修改数据
        console.log(data);
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

// 初始化加载所有类别
loadCategories();
