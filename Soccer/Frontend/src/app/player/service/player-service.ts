import { API_PLAYER } from 'app/com/config/prefix'
import axios from 'axios'

export const getPositionKey: ['getDistinctByPositionKey']
export const getPosition= async (id: number)=>{
    const {data} = await axios.get(`${API_PLAYER}/search`, {params:{q:'2', page: 1, limit: 10, sort:{order: 'decs'}}})
    return data
}

