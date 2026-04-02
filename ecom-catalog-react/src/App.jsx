import { useEffect, useState } from 'react';
import './App.css';
import ProductList from './ProductList';
import CategoryFilter from './CategoryFilter';

function App() {
  const [products, setProducts] = useState([]);
  const [categories, setCategories] = useState([]);
  const [selectCategories, setSelectedCategories] = useState(null);
  const [searchTerm, setSearchTerm] = useState("");
  const [sortOrder, setSortOrder] = useState("ascending");

  useEffect(() => {
    fetch('http://localhost:8080/api/products')
      .then(response => response.json())
      .then(data => setProducts(data))
      .catch(error => console.error("Error fetching data:", error));


      fetch('http://localhost:8080/api/categories')
      .then(response => response.json())
      .then(data => setCategories(data))
      .catch(error => console.error("Error fetching data:", error));
  }, []);

  const handleSearchChange=(event)=>{
    setSelectedCategories(event.target.value);
  };

  const handleSortChange=(event)=>{
    setSortOrder(event.target.value);
  }

  const handleCategorySelect=(categoryId)=>{
    setSelectedCategories(categoryId?Number(categoryId):null);
  }

  const filterProducts=products.filter(products=>{
    return(selectCategories ? products.category.id===selectCategories: true);
  });
  return (
    <div className="container">
      <h1 className="text-center my-4">Product Catalog</h1>

      <div className='row align-items-center mb-4'>
        <div className='col-md-3 col-sm-12 mb-2'>
          <CategoryFilter categories={categories} onSelect={handleCategorySelect}/>
        </div>
        <div className='col-md-5 col-sm-12 mb-2'>
          <input type="text" className='form-control' placeholder='Search for the Products' onChange={handleSearchChange}/>
        </div>

        <div className='col-md-4 col-sm-12 mb-2'>
          <select className='form-control' onChange={handleSortChange}>
          <option value="asc">Sort by Price: Low to High</option>
          <option value="desc">Sort by Price: Low to High</option>
          </select>
        </div>
      </div>
      {filterProducts.length ? (
        <ProductList products={filterProducts} />
      ) : (
        <p className="text-center">NO Products Found</p>
      )}
    </div>
  );
}

export default App;