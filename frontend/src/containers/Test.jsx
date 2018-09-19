import React from 'react';
import autobind from 'react-autobind';
import { FeatureFlag } from 'react-launch-darkly';

class TestLD extends React.PureComponent {
  constructor(props) {
    super(props);
    autobind(this);
  }


  renderFeature() {
    return <div>Feature enabled!</div>;
  }

  renderNoFeature() {
    return <div>Feature disabled!</div>;
  }

  renderLoading() {
    return <div>loading...</div>;
  }

  render() {
    return (
      <div>
        <FeatureFlag
          flagKey="flagtest"
          renderFeatureCallback={this.renderFeature}
          renderDefaultCallback={this.renderNoFeature}
          initialRenderCallback={this.renderLoading}
        />
      </div>);
  }
}

export default TestLD;

