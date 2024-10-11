import React, { useState } from 'react';
import CategoryList from './components/CategoryList';
import CategoryForm from './components/CategoryForm';
import Modal from './components/Modal';
import './Category.css';

function App() {
  const [isModalOpen, setIsModalOpen] = useState(false);

  const handleAddCategory = () => {
    setIsModalOpen(true);
  };

  const handleCloseModal = () => {
    setIsModalOpen(false);
  };

  const handleCategoryAdded = () => {
    // 刷新类别列表
  };

  return (
    <div className="container">
      <h1>商品类目管理</h1>
      <button id="addCategoryBtn" onClick={handleAddCategory}>添加类目</button>
      <CategoryList />
      <Modal isOpen={isModalOpen} onClose={handleCloseModal}>
        <h2>添加类目</h2>
        <CategoryForm onClose={handleCloseModal} onCategoryAdded={handleCategoryAdded} />
      </Modal>
    </div>
  );
}

export default App;