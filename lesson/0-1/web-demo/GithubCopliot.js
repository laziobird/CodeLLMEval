const apiUrl = 'http://127.0.0.1:8099/categories';

function fetchCategories() {
    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            const list = document.getElementById('category-list');
            list.innerHTML = '';
            data.forEach(category => {
                const li = document.createElement('li');
                li.textContent = `${category.id} - ${category.name}`;
                list.appendChild(li);
            });
        });
}

function searchCategories() {
    const id = document.getElementById('search-id').value;
    const name = document.getElementById('search-name').value;
    const url = `${apiUrl}/search?id=${id}&name=${name}`;
    fetch(url)
        .then(response => response.json())
        .then(data => {
            const list = document.getElementById('category-list');
            list.innerHTML = '';
            data.forEach(category => {
                const li = document.createElement('li');
                li.textContent = `${category.id} - ${category.name}`;
                list.appendChild(li);
            });
        });
}

function addCategory() {
    const category = {
        name: document.getElementById('category-name').value,
        level: document.getElementById('category-level').value,
        parentId: document.getElementById('category-parent-id').value,
        path: document.getElementById('category-path').value,
        status: document.getElementById('category-status').value,
        sort: document.getElementById('category-sort').value,
        remarks: document.getElementById('category-remarks').value
    };

    fetch(apiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(category)
    }).then(() => fetchCategories());
}

function updateCategory() {
    const category = {
        id: document.getElementById('category-id').value,
        name: document.getElementById('category-name').value,
        level: document.getElementById('category-level').value,
        parentId: document.getElementById('category-parent-id').value,
        path: document.getElementById('category-path').value,
        status: document.getElementById('category-status').value,
        sort: document.getElementById('category-sort').value,
        remarks: document.getElementById('category-remarks').value
    };

    fetch(apiUrl, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(category)
    }).then(() => fetchCategories());
}

function deleteCategory(id) {
    fetch(`${apiUrl}/${id}`, {
        method: 'DELETE'
    }).then(() => fetchCategories());
}

document.addEventListener('DOMContentLoaded', fetchCategories);