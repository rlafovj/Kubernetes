'use client'

import { MyTypography } from "@/app/components/common/style/cell"
import { saveArticle } from "@/redux/features/articles/article.service"
import { ThumbUpAlt, FmdGood, AttachFile } from "@mui/icons-material"
import { jwtDecode } from "jwt-decode"
import { useRouter } from "next/navigation"
import { parseCookies } from "nookies"
import { ChangeEvent, useEffect, useState } from "react"
import { useForm } from "react-hook-form"
import { useDispatch } from "react-redux"

export default function WriteArticlePage(){
  const dispatch = useDispatch()
  const router = useRouter()
  const { register, handleSubmit, formState: { errors } } = useForm();
  const [content, setContent] = useState('')

  const selecthandler = (e: any) => {
    setContent(e.target.value)
  }

  const handleInsert = ()=>{}

  const handelCancel = ()=>{}

  const options = [
    {boardId:1, title:"review", content:"리뷰게시판"},
    {boardId:2, title:"qna", content:"QnA게시판"},
    {boardId:3, title:"free", content:"자유게시판"}
  ]

  const onSubmit = (data: any)=>{
    alert(JSON.stringify(data))
    dispatch(saveArticle(data))
    .then((res: any)=>{
      const data = res.payload
      alert(`게시글 작성 완료 $(data)`)
      const boardId = data.boardId
      router.push(`/articles/list/${boardId}`)
    })
    .catch((err: any)=>{
      console.log('글 작성 에러 발생 : ${err}')
    })
  }


  useEffect(()=>{
    console.log('토큰을 디코드한 내용 : ')
    console.log(JSON.stringify(jwtDecode<any>(parseCookies().accessToken)))
    console.log('토큰을 디코드한 ID : ')
    console.log(jwtDecode<any>(parseCookies().accessToken).id)
  }, [])

return (<>

<form onSubmit={handleSubmit(onSubmit)} className="max-w-sm mx-auto">
  <label htmlFor="boardType" className="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Select your country</label>
  <select 
  {...register('boardId', {required: true})}
  id="boardType" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
 {options.map((item, index)=>(
 <option key={item.boardId} title={item.title} value={item.boardId}>{item.content}</option>
 ))
 
 }
    
    
  </select>

    <div className="editor mx-auto w-10/12 flex flex-col text-gray-800 border border-gray-300 p-4 shadow-lg max-w-2xl">
      {MyTypography('Article 작성', "1.5rem")}
      <input type="hidden" value={jwtDecode<any>(parseCookies().accessToken).id} readOnly/>
      <input {...register('writerId', {required: true})} type="hidden" value={jwtDecode<any>(parseCookies().accessToken).id} readOnly/>
      <input 
      {...register('title', {required: true, maxLength: 30})}
      className="title bg-gray-100 border border-gray-300 p-2 mb-4 outline-none" placeholder="Title" type="text" name="title" />

      <textarea 
       {...register('content', {required: true, maxLength: 300})}
      className="description bg-gray-100 sec p-3 h-60 border border-gray-300 outline-none" placeholder="Describe everything about this post here" name="content"></textarea>
      {/* <!-- icons --> */}
      <div className="icons flex text-gray-500 m-2">
        <svg className="mr-2 cursor-pointer hover:text-gray-700 border rounded-full p-1 h-7" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <ThumbUpAlt component={ThumbUpAlt}></ThumbUpAlt>
        </svg>
        <svg className="mr-2 cursor-pointer hover:text-gray-700 border rounded-full p-1 h-7" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <FmdGood component={FmdGood}></FmdGood>
        </svg>
        <svg className="mr-2 cursor-pointer hover:text-gray-700 border rounded-full p-1 h-7" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <AttachFile component={AttachFile}></AttachFile>
        </svg>
        <div className="count ml-auto text-gray-400 text-xs font-semibold">0/300</div>
      </div>
      {/* <!-- buttons --> */}
      <div className="buttons flex">
        <div className="btn  overflow-hidden relative w-30 bg-white text-blue-500 p-3 px-4 rounded-xl font-bold uppercase -- before:block before:absolute before:h-full before:w-1/2 before:rounded-full
        before:bg-pink-400 before:top-0 before:left-1/4 before:transition-transform before:opacity-0 before:hover:opacity-100 hover:text-200 hover:before:animate-ping transition-all duration-00"
          onClick={handelCancel}>Cancel</div>
        {/* <div className="btn  overflow-hidden relative w-30 bg-blue-500 text-white p-3 px-8 rounded-xl font-bold uppercase -- before:block before:absolute before:h-full before:w-1/2 before:rounded-full
        before:bg-pink-400 before:top-0 before:left-1/4 before:transition-transform before:opacity-0 before:hover:opacity-100 hover:text-200 hover:before:animate-ping transition-all duration-00"
          > Post </div> */}
          <input type="submit" value="SUBMIT" />
      </div>
    </div>
    </form>

</>)
}
