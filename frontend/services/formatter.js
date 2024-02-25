require('dotenv').config()
const {BACKEND_URL} = process.env

let format_date = (datestr) => {
    if (datestr != null) {
        const date = new Date(datestr)
        const year = date.getFullYear()
        const month = String(date.getMonth() + 1).padStart(2, '0')
        const day = String(date.getDate() + 1).padStart(2, '0')
        return `${year}-${month}-${day}`
    }
    return ''
}

let remove_nulls = (str) => (str != null) ? str : ''

let format_json = (item) =>
`
            <tr>
                <td>${remove_nulls(item.name)}</td>
                <td>${format_date(item.birthdate)}</td>
                <td>${remove_nulls(item.breed)}</td>
                <td>${remove_nulls(item.adopted)}</td>
                <td>
                    <div>
                        <button hx-delete="${BACKEND_URL}/dogs/id=${item.dog_id}" class="bi bi-trash-fill btn btn-danger" id="${item.id}"></button>
                    </div>
                </td>
            </tr>
`

let format_post = (body) => {
    let return_body = body
    console.log(body)
    if (body.adopted === 'on') return_body.adopted = true
    else return_body.adopted = false
    console.log(return_body)
    return return_body
}
exports.format_date = format_date
exports.remove_nulls = remove_nulls
exports.format_json = format_json
exports.format_post = format_post
