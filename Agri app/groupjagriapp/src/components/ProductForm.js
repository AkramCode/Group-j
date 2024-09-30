mport React, { useState } from 'react';
import api from '../services/api';
import { TextField, Button, Typography } from '@mui/material';
const ProductForm = () => {
const [product, setProduct] = useState({ name: '', category: '', price: 0, quantity: 0 });
const [success, setSuccess] = useState('');
const handleSubmit = (event) => {
event.preventDefault();
api.post('/products', product)
.then(() => {
setSuccess('Product added successfully');
})
.catch(error => {
console.error('Error adding product:', error);
});
};
return (
<form onSubmit={handleSubmit}>
<Typography variant="h4">Add Product</Typography>
<TextField label="Product Name" variant="outlined" fullWidth
value={product.name} onChange={(e) => setProduct({ ...product, name:
e.target.value })} />
<TextField label="Category" variant="outlined" fullWidth
value={product.category} onChange={(e) => setProduct({ ...product, category:
e.target.value })} />
<TextField label="Price" type="number" variant="outlined" fullWidth
value={product.price} onChange={(e) => setProduct({ ...product, price:
parseFloat(e.target.value) })} />
<TextField label="Quantity" type="number" variant="outlined" fullWidth
value={product.quantity} onChange={(e) => setProduct({ ...product, quantity:
parseInt(e.target.value, 10) })} />
{success && <Typography color="success">{success}</Typography>}
<Button
type="submit"
variant="contained"
color="primary">Add
Product</Button>
</form>
);
};
export default ProductForm;