import { NativeModules, Platform, Linking } from 'react-native';

const open = () => {
  if (Platform.OS === 'ios') {
    Linking.openURL('app-settings:');
  } else {
    NativeModules.OpenNotification.open();
  }
};

export default { open };
