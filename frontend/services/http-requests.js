const axios = require('axios')

let get = async (url) => {
    try {
        const response = await axios.get(url)
        return response.data
    } catch (e) {
        console.log(e)
        return []
    }
}

let post = async (url, body) => {
    try {
        const response = await axios.post(url, body)
        return response.data
    } catch (e) {
        console.log(e);
        return ['error'];
    }
}

let del = async (url) => {
    try {
        console.log(url)
        const response = await axios.delete(url);
        return response.data;
    } catch (e) {
        console.log(e);
        return ['error'];
    }
}

exports.get = get;
exports.post = post;
exports.del = del;
