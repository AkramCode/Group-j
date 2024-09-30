import axios from 'axios';
const api = axios.create({
baseURL: 'http://localhost:8080/api',
});
// Add a request interceptor to include the token in headers
api.interceptors.request.use(config => {
const token = localStorage.getItem('token');
if (token) {
config.headers['Authorization'] = `Bearer ${token}`;
}
return config;
}, error => {
return Promise.reject(error);
});
export default api;
Login Component (Login.js)
javascript
import React, { useState } from 'react';
import api from '../services/api';
import { TextField, Button, Typography } from '@mui/material';
const Login = () => {
const [user, setUser] = useState({ username: '', password: '' });
const [error, setError] = useState('');
const handleSubmit = (event) => {
    event.preventDefault();
    api.post('/auth/login', user)
    .then(response => {
    localStorage.setItem('token', response.data);
    window.location.href = '/'; // Redirect after successful login
    })
    .catch(error => {
    setError('Invalid credentials');
    });
    };
    return (
    <form onSubmit={handleSubmit}>
    <Typography variant="h4">Login</Typography>
    <TextField label="Username" variant="outlined" fullWidth
    value={user.username} onChange={(e) => setUser({ ...user, username:
    e.target.value })} />
    <TextField label="Password" type="password" variant="outlined" fullWidth
    value={user.password} onChange={(e) => setUser({ ...user, password:
    e.target.value })} />
    {error && <Typography color="error">{error}</Typography>}
    <Button type="submit" variant="contained" color="primary">Login</Button>
    </form>
    );
    };
    export default Login;
    `Signup Component (Signup.js)
    javascript
    import React, { useState } from 'react';
    import api from '../services/api';
    import { TextField, Button, Typography } from '@mui/material';
    const Signup = () => {
    const [user, setUser] = useState({ username: '', password: '', role: 'Buyer' });
    const [success, setSuccess] = useState('');
    const handleSubmit = (event) => {
    event.preventDefault();
    api.post('/auth/signup', user)
    .then(() => {
    setSuccess('User registered successfully!');
    })
.catch(error => {
console.error('Error during signup:', error);
});
};
return (
<form onSubmit={handleSubmit}>
<Typography variant="h4">Signup</Typography>
<TextField label="Username" variant="outlined" fullWidth
value={user.username} onChange={(e) => setUser({ ...user, username:
e.target.value })} />
<TextField label="Password" type="password" variant="outlined" fullWidth
value={user.password} onChange={(e) => setUser({ ...user, password:
e.target.value })} />
<TextField label="Role" variant="outlined" fullWidth
value={user.role} onChange={(e) => setUser({ ...user, role: e.target.value })}
/>
{success && <Typography color="success">{success}</Typography>}
<Button type="submit" variant="contained" color="primary">Signup</Button>
</form>
);
};
export default Signup;