import { Category } from './category';
import { Type } from './type';
import { Volume } from './volume';
import { LineNumber } from './line-number';

export interface IDropDownValues {
    categories: string[];
    lineNumbers: string[];
    categoryList: Category[];
    typeList: Type[];
    volumeList: Volume[];
    lineNumberList: LineNumber[];
  }
  