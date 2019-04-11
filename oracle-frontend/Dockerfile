FROM node:latest
RUN mkdir -p /src
WORKDIR /src
COPY package.json /src/
RUN npm install
RUN npm cache verify
COPY . /src
EXPOSE 4200
CMD ["npm","start"]
