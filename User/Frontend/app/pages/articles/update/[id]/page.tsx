'use client'

import { MyTypography } from "@/app/components/common/style/cell"
import { ThumbUpAlt, FmdGood, AttachFile } from "@mui/icons-material"
import { ChangeEvent } from "react"

export default function UpdateArticlePage(){

  const handleInsert = ()=>{
    
  }

  const handelCancel = ()=>{
   
  }

  const handleSubmit = ()=>{
    
  }

return (<>

<form className="max-w-sm mx-auto">
  <label htmlFor="boards" className="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Select Board</label>
  <select id="boards" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">

    <option>QnA</option>
    <option>Review</option>
  </select>
</form>

<div className="editor mx-auto w-10/12 flex flex-col text-gray-800 border border-gray-300 p-4 shadow-lg max-w-2xl">
      {MyTypography('게시글 작성', "1.5rem")}
      <input className="title bg-gray-100 border border-gray-300 p-2 mb-4 outline-none" placeholder="제목" type="text" name="title" onChange={handleInsert} />
      <textarea className="content bg-gray-100 sec p-3 h-60 border border-gray-300 outline-none" placeholder="내용을 입력하세요." name="content" onChange={handleInsert}></textarea>
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
        <div className="btn  overflow-hidden relative w-30 bg-blue-500 text-white p-3 px-8 rounded-xl font-bold uppercase -- before:block before:absolute before:h-full before:w-1/2 before:rounded-full
        before:bg-pink-400 before:top-0 before:left-1/4 before:transition-transform before:opacity-0 before:hover:opacity-100 hover:text-200 hover:before:animate-ping transition-all duration-00"
          onClick={handleSubmit}> Post </div>
      </div>
    </div>















</>)
}
