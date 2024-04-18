import { IBoard } from "@/redux/features/boards/board";

export interface BoardColumn{
    id?: string;
    boardName?: string;
    boardType?: string;
    regDate?: string;
    modDate?: string;
    array?: IBoard
    json?: IBoard
}