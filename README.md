# react-native-open-notification

[![NPM version](https://badge.fury.io/js/react-native-open-notification.svg)](https://www.npmjs.com/package/react-native-open-notification)

## Description

[React Native](https://facebook.github.io/react-native/) module to open app notification settings screen.

### Android

<img src='https://i.imgur.com/wnvjWFA.jpg' width="250px" />

### iOS

iOS's API currently does not allow opening app's notification settings directly.  
This module opens the app settings screen for iOS:

<img src='https://i.imgur.com/FZdF6p6.jpg' width="250px" />

## Installation

1. `npm install react-native-open-notification`
2. `react-native link react-native-open-notification` (only for React Native version < 0.60)

## Usage

```
import NotificationSetting from 'react-native-open-notification';

NotificationSetting.open();
```
