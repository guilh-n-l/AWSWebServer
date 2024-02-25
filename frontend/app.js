require('dotenv').config()
const http = require('./services/http-requests')
const express = require('express')
const axios = require('axios')
const {format_date, remove_nulls, format_json, format_post} = require("./services/formatter");
const app = express()
const port = 8081
const {BACKEND_URL} = process.env
const bodyParser = require('body-parser')
const {json} = require("express");

app.use(express.static('public'))
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

app.route('/data')
    .get(async (_, res) => {
        const data = await http.get(`${BACKEND_URL}/dogs`)
        const html = data.map(i => format_json(i)).join('')
        res.send(html)
    })
    .post(async (req, res) => {
        const object = req.body;
        const data = await http.post(`${BACKEND_URL}/dogs`, format_post(req.body));
        if (data[0] !== "error") {
            res.status(500);
        }
        else {
            res.status(200);
        }
    });

app.delete('/data/id=:id', async (req, res) => {
    const data = await http.del(`${BACKEND_URL}/dogs/id=${req.params.id}`); 
    if (data[0] !== "error") {
        res.status(500);
    }
    else {
        res.status(200);
    }
});

app.listen(port, () => {
    console.log(`${BACKEND_URL} Running at port ${port}`);
});
