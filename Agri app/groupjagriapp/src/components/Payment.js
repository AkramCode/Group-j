import React, { useState } from 'react';
import api from '../services/api';
import { TextField, Button, Typography } from '@mui/material';
const Payment = () => {
const [amount, setAmount] = useState(0);
const [success, setSuccess] = useState('');
const handlePayment = () => {
api.post('/payments', { amount: amount * 100 }) // Amount in cents
.then(response => {
setSuccess('Payment successful!');
})
.catch(error => {
console.error('Payment error:', error);
});
};
return (
<div>
<Typography variant="h4">Payment</Typography>
<TextField
type="number"
placeholder="Enter amount"
value={amount}
onChange={(e) => setAmount(e.target.value)}
/>
<Button
onClick={handlePayment}
variant="contained"
color="primary">Pay</Button>
{success && <Typography color="success">{success}</Typography>}
</div>
);
};
export default Payment;