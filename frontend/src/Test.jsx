import React from 'react';
import {FeatureFlag, LaunchDarkly} from 'react-launch-darkly';

class FlagTest extends React.Component {
  constructor(props) {
    super(props);
  }

  _renderFeature() {
    return <span>enabled</span>;
  }

  render() {
    const user = this.props.match.params.user;


    return (<LaunchDarkly clientId="5b8b254f7f3cf0154bde0c66" user={{ key: user }}>
      <div>
          Hello there, {user} - your feature is <FeatureFlag
            flagKey="flagtest"
            renderFeatureCallback={this._renderFeature}
          />
      </div>
    </LaunchDarkly>);
  }
}

export default FlagTest;
