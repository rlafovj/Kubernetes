import axios from "axios"
import { parseCookies } from "nookies"

 //export default function AxiosConfig(){
//     return {
//         headers:{
//         "Cache-Control": "no-cache",
//         "Content-Type": "application/json",
//          Authorization: `Bearer blah ~` ,
//         "Access-Control-Allow-Origin": "*",
//         }
//     }
// } 정적 방식

const instance = axios.create({baseURL: process.env.NEXT_PUBLIC_API_URL})

// 동적 방식
instance.interceptors.request.use(
    (request) => {
        const accessToken = parseCookies().accessToken;
        console.log('Axios 인터셉터 쿠키에서 토큰 추출함')
        request.headers['Content-Type'] = 'application/json'
        request.headers['Authorization'] = `Bearer ${accessToken}`
        return request
    },
    (error) => {
        console.log('Axios 인터셉터에서 발생한 에러 : '+error)
        return Promise.reject(error)
    }
)

instance.interceptors.response.use(
    (response) => {
        if(response.status === 404){
            console.log('Axios 인터셉터에서 토큰이 없으므로 404 에러 발생')
        }
        return response
    }
)


export default instance