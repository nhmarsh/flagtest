import React from 'react';
import {BrowserRouter, Link, Route} from 'react-router-dom';
import Home from './containers/Home';

const App = () => (
  <BrowserRouter>
    <Route path="/:user" component={Home} />
  </BrowserRouter>
);

export default App;
