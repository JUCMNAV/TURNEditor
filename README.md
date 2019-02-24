# TURNEditor
## Overview
TURN Editor is a collaborative editor for URN (User Requirements Notation. Currently, it supports TGRL (Textual
Goal-oriented Requirement Language) which is a part of TURN. The overall goal is to build a collaborative editor for
the complete URN, including its scenario/workflow notation Use Case Maps and support for the analysis of goal and scenario/workflow models. TURNEditor uses tColab framework which is based on the architecture of Eclipse Che and Theia. It has three parts - Backend (TURN Grammar Language Server and Sprotty Language Server Extension), Frontend (TURNEditor and Sprotty View), and Configuration (Docker Image and other configurations required to launch TGRL Theia extension in Eclipse Che to make it collaborative).

## Prerequisites
Node.js 8+
Yarn 1.2.1+
Git 2.11 +
Java 8+ (Stable version, Java 9 still has some issues)
Gradle 4.7+
Docker CE
git clone https://github.com/JUCMNAV/TURNEditor.git

## Launch TURNEditor locally in Browser 
Open Terminal and navigate to TURNEditor folder
cd Frontend
yarn
cd turn-app
yarn start

## Launch TURNEditor in development mode
For development it is better to connect to the running LSP through a socket.

Import Project in Eclipse or other IDE
Select projects and go to project->clean
Go to org.xtext.project.turn.tcolab.diagram->src->main->xtend-gen->org.xtext.project.turn.tcolab.diagram->RunSocketServer
Run As -> Java Application

Open Terminal and navigate to Frontend folder inside TURNEditor
cd turn-app
yarn run start:backend:socket

