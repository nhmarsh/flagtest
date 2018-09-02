import React from 'react';
import { BrowserRouter, Link, Route, Router } from 'react-router-dom';
import FlagTest from './Test';
import createBrowserHistory from 'history/createBrowserHistory';

class App extends React.Component {
  render() {
    const history = createBrowserHistory();
    return (
      <Router history={history}>
        <Route path="/:user" component={FlagTest} />
      </Router>);
  }
}

export default App;
