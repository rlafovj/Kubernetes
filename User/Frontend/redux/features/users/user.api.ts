import instance from "@/redux/common/configs/axios-config";

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

export const logoutAPI = async () => {
    try{
        const response = await instance.get(`/users/exists-username`,{params: {}})
        console.log('logoutAPI 결과: '+ response.data)
        return response.data
    }catch(error){
        console.log(error)
        return error
    }
}

export const existsUsernameAPI = async(username: string)=>{
    try {
        const response = await instance.post('/users/exists-username', username)
        console.log(response.data.message)
        return response.data
    } catch (error) {
        console.log("existsUsernameAPI Error : "+error)
        return error
    }
}