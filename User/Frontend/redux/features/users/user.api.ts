import instance from "@/redux/common/configs/axios-config";
import { IUser } from "./user.model";

export const findAllUsersAPI = async(page: number)=>{
    try {
        const response = await instance().get(`/users/list`,{
        params: {page, limit: 10}
    })
        return response.data
    } catch (error) {
        console.log("getAllUsersAPI Error : "+error)
        return error
    }
}
export const loginAPI = async(user: IUser)=>{
    try {
        const response = await instance().post(`/auth/login`, user)
        console.log("loginAPI 보내는 값"+response.data.message)
        return response.data
    } catch (error) {
        console.log("loginAPI Error : "+error)
        return error
    }
}

export const logoutAPI = async () => {
    try{
        const response = await instance().get(`/users/logout`)
        console.log('logoutAPI 결과: '+ response.data)
        return response.data
    }catch(error){
        console.log(error)
        return error
    }
}

export const existsUsernameAPI = async(username: string)=>{
    try {
        console.log(await instance().get(`/users/exists-username`,{params: {username}}))
        const response = await instance().get(`/users/exists-username`, {params: {username}})
        console.log(response.data)
        return response.data
    } catch (error) {
        console.log("existsUsernameAPI Error : "+error)
        return error
    }
}