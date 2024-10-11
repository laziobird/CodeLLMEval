import React, { useState, useEffect } from 'react';

const CategoryList = () => {
  const [categories, setCategories] = useState([]);
  const [searchId, setSearchId] = useState('');
  const [searchName, setSearchName] = useState('');

  useEffect(() => {
    loadCategories();
  }, []);

  const loadCategories = () => {
    fetch('http://127.0.0.1:8099/categories')
      .then(response => response.json())
      .then(data => setCategories(data))
      .catch(error => console.error('Error:', error));
  };

  const searchCategories = () => {
    fetch(`http://127.0.0.1:8099/categories/search?id=${searchId}&name=${searchName}`)
      .then(response => response.json())
      .then(data => setCategories(data))
      .catch(error => console.error('Error:', error));
  };

  const deleteCategory = (id) => {
    if (window.confirm('确定删除吗？')) {
      fetch(`http://127.0.0.1:8099/categories/${id}`, { method: 'DELETE' })
        .then(response => response.json())
        .then(() => loadCategories())
        .catch(error => console.error('Error:', error));
    }
  };

  return (
    <div id="categoryList">
      <input
        type="text"
        value={searchId}
        onChange={(e) => setSearchId(e.target.value)}
        placeholder="搜索ID"
      />
      <input
        type="text"
        value={searchName}
        onChange={(e) => setSearchName(e.target.value)}
        placeholder="搜索名称"
      />
      <button onClick={searchCategories}>搜索</button>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>名称</th>
            <th>层级</th>
            <th>状态</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody>
          {categories.map(category => (
            <tr key={category.id}>
              <td>{category.id}</td>
              <td>{category.name}</td>
              <td>{category.level}</td>
              <td>{category.status === 1 ? '启用' : '禁用'}</td>
              <td>
                <button onClick={() => console.log('Edit', category.id)}>编辑</button>
                <button onClick={() => deleteCategory(category.id)}>删除</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default CategoryList;