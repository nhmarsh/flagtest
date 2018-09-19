import React from 'react';
import { LaunchDarkly } from 'react-launch-darkly';
import TestLD from './Test';

class Home extends React.PureComponent {
  constructor(props) {
    super(props);
  }

  render() {
    return (<main className="container">
      <LaunchDarkly clientId="5b8b254f7f3cf0154bde0c66" user={{ key: this.props.match.params.user }}>
        <TestLD />
      </LaunchDarkly>

    </main>);
  }
}

export default Home;
