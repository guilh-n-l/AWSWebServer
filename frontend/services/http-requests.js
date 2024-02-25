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
        console.log(body)
        const response = await axios.post(url, body)
        return response.data
    } catch (e) {
        console.log(e)
        return ['error']
    }
}

exports.get = get
exports.post = post