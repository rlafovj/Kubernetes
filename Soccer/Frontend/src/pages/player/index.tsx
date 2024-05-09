import PlayerList from 'app/player/module/player-list'
import { NextPage } from 'next'
import Home from 'templates/Home'
import {
    QueryClient,
    QueryClientProvider,
    useQuery,
} from '@tanstack/react-query'
import { getPosition, getPositionKey } from 'app/player/service/player-service'

// interface props {
//     data: {title: string}

// }

const PlayerPage: NextPage = ({data}: any) => {
    return <PlayerList />
}

export async function getServerSideProps() {

    const queryClient = new QueryClient()
    await queryClient.prefetchQuery(getPositionKey, getPosition)
    const data = queryClient.getQueryData(getPositionKey)
    // const result = await fetch('https://api.github.com/repos/TanStack/query').then((res) => {res.json()})
    console.log('MY_INFO : PlayerPage SSR data is')
    console.log(JSON.stringify(data))
    return {
        props: {data}
    }
}


export default PlayerPage