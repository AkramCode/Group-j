import React, { useEffect, useState } from 'react';
import api from '../services/api';
import { Button, Typography } from '@mui/material';
const ProductList = () => {
const [products, setProducts] = useState([]);
useEffect(() => {
api.get('/products')
.then(response => {
setProducts(response.data);
})
.catch(error => {
console.error('Error fetching products:', error);
});
}, []);
return (
    <div>
    <Typography variant="h4">Product List</Typography>
    <ul>
    {products.map(product => (
    <li key={product.productID}>
    <Typography>{product.name}
    -
    {product.category}
    -
    ${product.price}</Typography>
    </li>
    ))}
    </ul>
    <Button
    variant="contained"
    color="primary"
    href="/add-product">Add
    Product</Button>
    </div>
    );
    };
    export default ProductList;