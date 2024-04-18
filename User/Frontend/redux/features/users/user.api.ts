import { instance } from "@/redux/common/configs/axios-config"

export const findAllUsersAPI = async(page: number)=>{
    try {
        const response = await instance.get('/users/list',{
        params: {page, limit: 10}
    })
        return response.data
    } catch (error) {
        console.log("getAllUsersAPI Error : "+error)
        return error
    }
}
export const loginAPI = async(userCredentials: {username: string, password: string})=>{
    try {
        const response = await instance.post('/users/login', userCredentials)
        console.log(response.data.message)
        return response.data
    } catch (error) {
        console.log("loginAPI Error : "+error)
        return error
    }
}