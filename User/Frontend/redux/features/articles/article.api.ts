import  instance  from '@/redux/common/configs/axios-config'

export const findAllArticlesAPI = async (page: number) => {
    try {
        const response = await instance().get('/articles/list',{
            params: {page, limit: 10}
        })
        console.log('-------test----------')
        console.log(response.data)
        return response.data
    } catch (error) {
        console.log('findArticleAPI Error : '+error)
        return error
    }
}

export const findArticleByBoardIdAPI = async (page: number ,id: number) => {
    try{
    return (await instance().get(`/articles/list/${id}`, {params: {page, limit: 10, id}})).data
    } catch (error) {
    console.log(error)
    return error
    }
}
