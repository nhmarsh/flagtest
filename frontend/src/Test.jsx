import React from 'react';
import { FeatureFlag, LaunchDarkly } from 'react-launch-darkly';
import autoBind from 'react-autobind';

class FlagTest extends React.Component {
  constructor(props) {
    super(props);
    autoBind(this);
  }

  renderFeature() {
    return <span>Enabled!</span>;
  }
  renderDefault() {
    return <span>Disabled!</span>;
  }

  render() {
    const user = this.props.match.params.user;
    console.log('Rendering!');

    return (<LaunchDarkly clientId="5b8b254f7f3cf0154bde0c66" user={{ key: user }}>
      <div>
          Hello there, {user} - your feature is <FeatureFlag
            flagKey="flagtest"
            renderFeatureCallback={this.renderFeature}
            renderDefaultCallback={this.renderDefault}
          />
      </div>
    </LaunchDarkly>);
  }
}

export default FlagTest;
