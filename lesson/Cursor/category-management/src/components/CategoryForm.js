import React, { useState } from 'react';

const CategoryForm = ({ onClose, onCategoryAdded }) => {
  const [formData, setFormData] = useState({
    name: '',
    level: '',
    parentId: '0',
    path: '',
    status: '1',
    sort: '',
    remarks: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    fetch('http://127.0.0.1:8099/categories', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(formData)
    })
    .then(response => response.json())
    .then(() => {
      onCategoryAdded();
      onClose();
    })
    .catch(error => console.error('Error:', error));
  };

  return (
    <form onSubmit={handleSubmit}>
      <input type="text" name="name" value={formData.name} onChange={handleChange} placeholder="类目名称" required />
      <input type="number" name="level" value={formData.level} onChange={handleChange} placeholder="类目层级" min="1" max="3" required />
      <input type="number" name="parentId" value={formData.parentId} onChange={handleChange} placeholder="父类目ID" />
      <input type="text" name="path" value={formData.path} onChange={handleChange} placeholder="类目路径" />
      <select name="status" value={formData.status} onChange={handleChange}>
        <option value="1">启用</option>
        <option value="0">禁用</option>
      </select>
      <input type="number" name="sort" value={formData.sort} onChange={handleChange} placeholder="排序权重" />
      <input type="text" name="remarks" value={formData.remarks} onChange={handleChange} placeholder="备注" />
      <button type="submit">添加类目</button>
    </form>
  );
};

export default CategoryForm;