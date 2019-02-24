# TURNEditor
## Overview
TURN Editor is a collaborative editor for URN (User Requirements Notation. Currently, it supports TGRL (Textual
Goal-oriented Requirement Language) which is a part of TURN. The overall goal is to build a collaborative editor for
the complete URN, including its scenario/workflow notation Use Case Maps and support for the analysis of goal and scenario/workflow models. TURNEditor uses tColab framework which is based on the architecture of Eclipse Che and Theia. It has three parts - Backend (TURN Grammar Language Server and Sprotty Language Server Extension), Frontend (TURNEditor and Sprotty View), and Configuration (Docker Image and other configurations required to launch TGRL Theia extension in Eclipse Che to make it collaborative).

## Prerequisites
* **Building TURNEditor for Browser **
```
[Node.js] (https://nodejs.org/en/download/package-manager/)
[Yarn] (https://yarnpkg.com/lang/en/docs/install/#debian-stable)
[Gradle] (https://gradle.org/install/)
```
* **Launching TURNEditor in Eclipse Che  **
```
[Docker CE] (https://docs.docker.com/install/)
[Eclipse Che] (https://www.eclipse.org/che/docs/che-6/quick-start.html)
```

## Launch TURNEditor locally in Browser
```
git clone https://github.com/JUCMNAV/TURNEditor.git
```
Open Terminal and navigate to TURNEditor folder
```
cd Frontend
yarn
cd turn-app
yarn start
```

## Launch TURNEditor in development mode
For development it is better to connect to the running LSP through a socket.
```
Import Project in Eclipse or other IDE
Select projects and go to *project -> clean*
Go to *org.xtext.project.turn.tcolab.diagram -> src -> main -> xtend-gen-> org.xtext.project.turn.tcolab.diagram -> RunSocketServer*
*Run As -> Java Application*
```
Open Terminal and navigate to Frontend folder inside TURNEditor
```
cd turn-app
yarn run start:backend:socket
```

