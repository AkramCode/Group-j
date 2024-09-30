javascript
import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ProductList from './components/ProductList';
import ProductForm from './components/ProductForm';
import Login from './components/Login';
import Signup from './components/Signup';
function App() {
return (
<Router>
<Switch>
<Route exact path="/" component={ProductList} />
<Route path="/add-product" component={ProductForm} />
<Route path="/login" component={Login} />
<Route path="/signup" component={Signup} />
</Switch>
</Router>
);
}
export default App;