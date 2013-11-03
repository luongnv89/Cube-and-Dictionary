interface MPI_Wtick

function MPI_Wtick()
    double precision MPI_Wtick
end function MPI_Wtick

end interface


interface MPI_Wtime

function MPI_Wtime()
    double precision MPI_Wtime
end function MPI_Wtime

end interface


interface MPI_Abort

subroutine MPI_Abort(comm, errorcode, ierr)
  integer, intent(in) :: comm
  integer, intent(in) :: errorcode
  integer, intent(out) :: ierr
end subroutine MPI_Abort

end interface


interface MPI_Add_error_class

subroutine MPI_Add_error_class(errorclass, ierr)
  integer, intent(in) :: errorclass
  integer, intent(out) :: ierr
end subroutine MPI_Add_error_class

end interface


interface MPI_Add_error_code

subroutine MPI_Add_error_code(errorclass, errorcode, ierr)
  integer, intent(in) :: errorclass
  integer, intent(out) :: errorcode
  integer, intent(out) :: ierr
end subroutine MPI_Add_error_code

end interface


interface MPI_Add_error_string

subroutine MPI_Add_error_string(errorcode, string, ierr)
  integer, intent(in) :: errorcode
  character(len=*), intent(in) :: string
  integer, intent(out) :: ierr
end subroutine MPI_Add_error_string

end interface


interface MPI_Attr_delete

subroutine MPI_Attr_delete(comm, keyval, ierr)
  integer, intent(in) :: comm
  integer, intent(in) :: keyval
  integer, intent(out) :: ierr
end subroutine MPI_Attr_delete

end interface


interface MPI_Attr_get

subroutine MPI_Attr_get(comm, keyval, attribute_val, flag, ierr)
  integer, intent(in) :: comm
  integer, intent(in) :: keyval
  integer, intent(out) :: attribute_val
  logical, intent(out) :: flag
  integer, intent(out) :: ierr
end subroutine MPI_Attr_get

end interface


interface MPI_Attr_put

subroutine MPI_Attr_put(comm, keyval, attribute_val, ierr)
  integer, intent(in) :: comm
  integer, intent(in) :: keyval
  integer, intent(in) :: attribute_val
  integer, intent(out) :: ierr
end subroutine MPI_Attr_put

end interface


interface MPI_Barrier

subroutine MPI_Barrier(comm, ierr)
  integer, intent(in) :: comm
  integer, intent(out) :: ierr
end subroutine MPI_Barrier

end interface


interface MPI_Cancel

subroutine MPI_Cancel(request, ierr)
  integer, intent(in) :: request
  integer, intent(out) :: ierr
end subroutine MPI_Cancel

end interface


interface MPI_Cart_coords

subroutine MPI_Cart_coords(comm, rank, maxdims, coords, ierr)
  integer, intent(in) :: comm
  integer, intent(in) :: rank
  integer, intent(in) :: maxdims
  integer, dimension(*), intent(out) :: coords
  integer, intent(out) :: ierr
end subroutine MPI_Cart_coords

end interface


interface MPI_Cart_create

subroutine MPI_Cart_create(old_comm, ndims, dims, periods, reorder, &
        comm_cart, ierr)
  integer, intent(in) :: old_comm
  integer, intent(in) :: ndims
  integer, dimension(*), intent(in) :: dims
  logical, dimension(*), intent(in) :: periods
  logical, intent(in) :: reorder
  integer, intent(out) :: comm_cart
  integer, intent(out) :: ierr
end subroutine MPI_Cart_create

end interface


interface MPI_Cart_get

subroutine MPI_Cart_get(comm, maxdims, dims, periods, coords&
        , ierr)
  integer, intent(in) :: comm
  integer, intent(in) :: maxdims
  integer, dimension(*), intent(out) :: dims
  logical, dimension(*), intent(out) :: periods
  integer, dimension(*), intent(out) :: coords
  integer, intent(out) :: ierr
end subroutine MPI_Cart_get

end interface


interface MPI_Cart_map

subroutine MPI_Cart_map(comm, ndims, dims, periods, newrank&
        , ierr)
  integer, intent(in) :: comm
  integer, intent(in) :: ndims
  integer, dimension(*), intent(in) :: dims
  integer, dimension(*), intent(in) :: periods
  integer, intent(out) :: newrank
  integer, intent(out) :: ierr
end subroutine MPI_Cart_map

end interface


interface MPI_Cart_rank

subroutine MPI_Cart_rank(comm, coords, rank, ierr)
  integer, intent(in) :: comm
  integer, dimension(*), intent(in) :: coords
  integer, intent(out) :: rank
  integer, intent(out) :: ierr
end subroutine MPI_Cart_rank

end interface


interface MPI_Cart_shift

subroutine MPI_Cart_shift(comm, direction, disp, rank_source, rank_dest&
        , ierr)
  integer, intent(in) :: comm
  integer, intent(in) :: direction
  integer, intent(in) :: disp
  integer, intent(out) :: rank_source
  integer, intent(out) :: rank_dest
  integer, intent(out) :: ierr
end subroutine MPI_Cart_shift

end interface


interface MPI_Cart_sub

subroutine MPI_Cart_sub(comm, remain_dims, new_comm, ierr)
  integer, intent(in) :: comm
  logical, dimension(*), intent(in) :: remain_dims
  integer, intent(out) :: new_comm
  integer, intent(out) :: ierr
end subroutine MPI_Cart_sub

end interface


interface MPI_Cartdim_get

subroutine MPI_Cartdim_get(comm, ndims, ierr)
  integer, intent(in) :: comm
  integer, intent(out) :: ndims
  integer, intent(out) :: ierr
end subroutine MPI_Cartdim_get

end interface


interface MPI_Comm_call_errhandler

subroutine MPI_Comm_call_errhandler(comm, errorcode, ierr)
  integer, intent(in) :: comm
  integer, intent(in) :: errorcode
  integer, intent(out) :: ierr
end subroutine MPI_Comm_call_errhandler

end interface


interface MPI_Comm_compare

subroutine MPI_Comm_compare(comm1, comm2, result, ierr)
  integer, intent(in) :: comm1
  integer, intent(in) :: comm2
  integer, intent(out) :: result
  integer, intent(out) :: ierr
end subroutine MPI_Comm_compare

end interface


interface MPI_Comm_create

subroutine MPI_Comm_create(comm, group, newcomm, ierr)
  integer, intent(in) :: comm
  integer, intent(in) :: group
  integer, intent(out) :: newcomm
  integer, intent(out) :: ierr
end subroutine MPI_Comm_create

end interface


interface MPI_Comm_create_errhandler

subroutine MPI_Comm_create_errhandler(function, errhandler, ierr)
  external :: function
  integer, intent(out) :: errhandler
  integer, intent(out) :: ierr
end subroutine MPI_Comm_create_errhandler

end interface


interface MPI_Comm_create_keyval

subroutine MPI_Comm_create_keyval(comm_copy_attr_fn, comm_delete_attr_fn, comm_keyval, extra_state, ierr)
  include 'mpif-config.h'
  external :: comm_copy_attr_fn
  external :: comm_delete_attr_fn
  integer, intent(out) :: comm_keyval
  integer(kind=MPI_ADDRESS_KIND), intent(in) :: extra_state
  integer, intent(out) :: ierr
end subroutine MPI_Comm_create_keyval

end interface


interface MPI_Comm_delete_attr

subroutine MPI_Comm_delete_attr(comm, comm_keyval, ierr)
  integer, intent(inout) :: comm
  integer, intent(in) :: comm_keyval
  integer, intent(out) :: ierr
end subroutine MPI_Comm_delete_attr

end interface


interface MPI_Comm_dup

subroutine MPI_Comm_dup(comm, newcomm, ierr)
  integer, intent(in) :: comm
  integer, intent(out) :: newcomm
  integer, intent(out) :: ierr
end subroutine MPI_Comm_dup

end interface


interface MPI_Comm_free

subroutine MPI_Comm_free(comm, ierr)
  integer, intent(inout) :: comm
  integer, intent(out) :: ierr
end subroutine MPI_Comm_free

end interface


interface MPI_Comm_free_keyval

subroutine MPI_Comm_free_keyval(comm_keyval, ierr)
  integer, intent(inout) :: comm_keyval
  integer, intent(out) :: ierr
end subroutine MPI_Comm_free_keyval

end interface


interface MPI_Comm_get_attr

subroutine MPI_Comm_get_attr(comm, comm_keyval, attribute_val, flag, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: comm
  integer, intent(in) :: comm_keyval
  integer(kind=MPI_ADDRESS_KIND), intent(out) :: attribute_val
  logical, intent(out) :: flag
  integer, intent(out) :: ierr
end subroutine MPI_Comm_get_attr

end interface


interface MPI_Comm_get_errhandler

subroutine MPI_Comm_get_errhandler(comm, erhandler, ierr)
  integer, intent(in) :: comm
  integer, intent(out) :: erhandler
  integer, intent(out) :: ierr
end subroutine MPI_Comm_get_errhandler

end interface


interface MPI_Comm_get_name

subroutine MPI_Comm_get_name(comm, comm_name, resultlen, ierr)
  integer, intent(in) :: comm
  character(len=*), intent(out) :: comm_name
  integer, intent(out) :: resultlen
  integer, intent(out) :: ierr
end subroutine MPI_Comm_get_name

end interface


interface MPI_Comm_group

subroutine MPI_Comm_group(comm, group, ierr)
  integer, intent(in) :: comm
  integer, intent(out) :: group
  integer, intent(out) :: ierr
end subroutine MPI_Comm_group

end interface


interface MPI_Comm_rank

subroutine MPI_Comm_rank(comm, rank, ierr)
  integer, intent(in) :: comm
  integer, intent(out) :: rank
  integer, intent(out) :: ierr
end subroutine MPI_Comm_rank

end interface


interface MPI_Comm_remote_group

subroutine MPI_Comm_remote_group(comm, group, ierr)
  integer, intent(in) :: comm
  integer, intent(out) :: group
  integer, intent(out) :: ierr
end subroutine MPI_Comm_remote_group

end interface


interface MPI_Comm_remote_size

subroutine MPI_Comm_remote_size(comm, size, ierr)
  integer, intent(in) :: comm
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Comm_remote_size

end interface


interface MPI_Comm_set_attr

subroutine MPI_Comm_set_attr(comm, comm_keyval, attribute_val, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: comm
  integer, intent(in) :: comm_keyval
  integer(kind=MPI_ADDRESS_KIND), intent(in) :: attribute_val
  integer, intent(out) :: ierr
end subroutine MPI_Comm_set_attr

end interface


interface MPI_Comm_set_errhandler

subroutine MPI_Comm_set_errhandler(comm, errhandler, ierr)
  integer, intent(in) :: comm
  integer, intent(in) :: errhandler
  integer, intent(out) :: ierr
end subroutine MPI_Comm_set_errhandler

end interface


interface MPI_Comm_set_name

subroutine MPI_Comm_set_name(comm, comm_name, ierr)
  integer, intent(inout) :: comm
  character(len=*), intent(in) :: comm_name
  integer, intent(out) :: ierr
end subroutine MPI_Comm_set_name

end interface


interface MPI_Comm_size

subroutine MPI_Comm_size(comm, size, ierr)
  integer, intent(in) :: comm
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Comm_size

end interface


interface MPI_Comm_split

subroutine MPI_Comm_split(comm, color, key, newcomm, ierr)
  integer, intent(in) :: comm
  integer, intent(in) :: color
  integer, intent(in) :: key
  integer, intent(out) :: newcomm
  integer, intent(out) :: ierr
end subroutine MPI_Comm_split

end interface


interface MPI_Comm_test_inter

subroutine MPI_Comm_test_inter(comm, flag, ierr)
  integer, intent(in) :: comm
  logical, intent(in) :: flag
  integer, intent(out) :: ierr
end subroutine MPI_Comm_test_inter

end interface


interface MPI_Dims_create

subroutine MPI_Dims_create(nnodes, ndims, dims, ierr)
  integer, intent(in) :: nnodes
  integer, intent(in) :: ndims
  integer, dimension(*), intent(inout) :: dims
  integer, intent(out) :: ierr
end subroutine MPI_Dims_create

end interface


interface MPI_Errhandler_create

subroutine MPI_Errhandler_create(function, errhandler, ierr)
  external :: function
  integer, intent(out) :: errhandler
  integer, intent(out) :: ierr
end subroutine MPI_Errhandler_create

end interface


interface MPI_Errhandler_free

subroutine MPI_Errhandler_free(errhandler, ierr)
  integer, intent(inout) :: errhandler
  integer, intent(out) :: ierr
end subroutine MPI_Errhandler_free

end interface


interface MPI_Errhandler_get

subroutine MPI_Errhandler_get(comm, errhandler, ierr)
  integer, intent(in) :: comm
  integer, intent(out) :: errhandler
  integer, intent(out) :: ierr
end subroutine MPI_Errhandler_get

end interface


interface MPI_Errhandler_set

subroutine MPI_Errhandler_set(comm, errhandler, ierr)
  integer, intent(in) :: comm
  integer, intent(in) :: errhandler
  integer, intent(out) :: ierr
end subroutine MPI_Errhandler_set

end interface


interface MPI_Error_class

subroutine MPI_Error_class(errorcode, errorclass, ierr)
  integer, intent(in) :: errorcode
  integer, intent(out) :: errorclass
  integer, intent(out) :: ierr
end subroutine MPI_Error_class

end interface


interface MPI_Error_string

subroutine MPI_Error_string(errorcode, string, resultlen, ierr)
  integer, intent(in) :: errorcode
  character(len=*), intent(out) :: string
  integer, intent(out) :: resultlen
  integer, intent(out) :: ierr
end subroutine MPI_Error_string

end interface


interface MPI_File_call_errhandler

subroutine MPI_File_call_errhandler(fh, errorcode, ierr)
  integer, intent(in) :: fh
  integer, intent(in) :: errorcode
  integer, intent(out) :: ierr
end subroutine MPI_File_call_errhandler

end interface


interface MPI_File_close

subroutine MPI_File_close(fh, ierr)
  integer, intent(inout) :: fh
  integer, intent(out) :: ierr
end subroutine MPI_File_close

end interface


interface MPI_File_create_errhandler

subroutine MPI_File_create_errhandler(function, errhandler, ierr)
  external :: function
  integer, intent(out) :: errhandler
  integer, intent(out) :: ierr
end subroutine MPI_File_create_errhandler

end interface


interface MPI_File_delete

subroutine MPI_File_delete(filename, info, ierr)
  character(len=*), intent(in) :: filename
  integer, intent(in) :: info
  integer, intent(out) :: ierr
end subroutine MPI_File_delete

end interface


interface MPI_File_get_amode

subroutine MPI_File_get_amode(fh, amode, ierr)
  integer, intent(in) :: fh
  integer, intent(out) :: amode
  integer, intent(out) :: ierr
end subroutine MPI_File_get_amode

end interface


interface MPI_File_get_atomicity

subroutine MPI_File_get_atomicity(fh, flag, ierr)
  integer, intent(in) :: fh
  logical, intent(out) :: flag
  integer, intent(out) :: ierr
end subroutine MPI_File_get_atomicity

end interface


interface MPI_File_get_byte_offset

subroutine MPI_File_get_byte_offset(fh, offset, disp, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: fh
  integer(kind=MPI_OFFSET_KIND), intent(in) :: offset
  integer(kind=MPI_OFFSET_KIND), intent(out) :: disp
  integer, intent(out) :: ierr
end subroutine MPI_File_get_byte_offset

end interface


interface MPI_File_get_errhandler

subroutine MPI_File_get_errhandler(file, errhandler, ierr)
  integer, intent(in) :: file
  integer, intent(out) :: errhandler
  integer, intent(out) :: ierr
end subroutine MPI_File_get_errhandler

end interface


interface MPI_File_get_group

subroutine MPI_File_get_group(fh, group, ierr)
  integer, intent(in) :: fh
  integer, intent(out) :: group
  integer, intent(out) :: ierr
end subroutine MPI_File_get_group

end interface


interface MPI_File_get_info

subroutine MPI_File_get_info(fh, info_used, ierr)
  integer, intent(in) :: fh
  integer, intent(out) :: info_used
  integer, intent(out) :: ierr
end subroutine MPI_File_get_info

end interface


interface MPI_File_get_position

subroutine MPI_File_get_position(fh, offset, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: fh
  integer(kind=MPI_OFFSET_KIND), intent(out) :: offset
  integer, intent(out) :: ierr
end subroutine MPI_File_get_position

end interface


interface MPI_File_get_position_shared

subroutine MPI_File_get_position_shared(fh, offset, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: fh
  integer(kind=MPI_OFFSET_KIND), intent(out) :: offset
  integer, intent(out) :: ierr
end subroutine MPI_File_get_position_shared

end interface


interface MPI_File_get_size

subroutine MPI_File_get_size(fh, size, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: fh
  integer(kind=MPI_OFFSET_KIND), intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_File_get_size

end interface


interface MPI_File_get_type_extent

subroutine MPI_File_get_type_extent(fh, datatype, extent, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: fh
  integer, intent(in) :: datatype
  integer(kind=MPI_ADDRESS_KIND), intent(out) :: extent
  integer, intent(out) :: ierr
end subroutine MPI_File_get_type_extent

end interface


interface MPI_File_get_view

subroutine MPI_File_get_view(fh, disp, etype, filetype, datarep&
        , ierr)
  include 'mpif-config.h'
  integer, intent(in) :: fh
  integer(kind=MPI_OFFSET_KIND), intent(out) :: disp
  integer, intent(out) :: etype
  integer, intent(out) :: filetype
  character(len=*), intent(out) :: datarep
  integer, intent(out) :: ierr
end subroutine MPI_File_get_view

end interface


interface MPI_File_open

subroutine MPI_File_open(comm, filename, amode, info, fh&
        , ierr)
  integer, intent(in) :: comm
  character(len=*), intent(in) :: filename
  integer, intent(in) :: amode
  integer, intent(in) :: info
  integer, intent(out) :: fh
  integer, intent(out) :: ierr
end subroutine MPI_File_open

end interface


interface MPI_File_preallocate

subroutine MPI_File_preallocate(fh, size, ierr)
  include 'mpif-config.h'
  integer, intent(inout) :: fh
  integer(kind=MPI_OFFSET_KIND), intent(in) :: size
  integer, intent(out) :: ierr
end subroutine MPI_File_preallocate

end interface


interface MPI_File_seek

subroutine MPI_File_seek(fh, offset, whence, ierr)
  include 'mpif-config.h'
  integer, intent(inout) :: fh
  integer(kind=MPI_OFFSET_KIND), intent(in) :: offset
  integer, intent(in) :: whence
  integer, intent(out) :: ierr
end subroutine MPI_File_seek

end interface


interface MPI_File_seek_shared

subroutine MPI_File_seek_shared(fh, offset, whence, ierr)
  include 'mpif-config.h'
  integer, intent(inout) :: fh
  integer(kind=MPI_OFFSET_KIND), intent(in) :: offset
  integer, intent(in) :: whence
  integer, intent(out) :: ierr
end subroutine MPI_File_seek_shared

end interface


interface MPI_File_set_atomicity

subroutine MPI_File_set_atomicity(fh, flag, ierr)
  integer, intent(inout) :: fh
  logical, intent(in) :: flag
  integer, intent(out) :: ierr
end subroutine MPI_File_set_atomicity

end interface


interface MPI_File_set_errhandler

subroutine MPI_File_set_errhandler(file, errhandler, ierr)
  integer, intent(in) :: file
  integer, intent(in) :: errhandler
  integer, intent(out) :: ierr
end subroutine MPI_File_set_errhandler

end interface


interface MPI_File_set_info

subroutine MPI_File_set_info(fh, info, ierr)
  integer, intent(inout) :: fh
  integer, intent(in) :: info
  integer, intent(out) :: ierr
end subroutine MPI_File_set_info

end interface


interface MPI_File_set_size

subroutine MPI_File_set_size(fh, size, ierr)
  include 'mpif-config.h'
  integer, intent(inout) :: fh
  integer(kind=MPI_OFFSET_KIND), intent(in) :: size
  integer, intent(out) :: ierr
end subroutine MPI_File_set_size

end interface


interface MPI_File_set_view

subroutine MPI_File_set_view(fh, disp, etype, filetype, datarep, &
        info, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: fh
  integer(kind=MPI_OFFSET_KIND), intent(in) :: disp
  integer, intent(in) :: etype
  integer, intent(in) :: filetype
  character(len=*), intent(in) :: datarep
  integer, intent(in) :: info
  integer, intent(out) :: ierr
end subroutine MPI_File_set_view

end interface


interface MPI_File_sync

subroutine MPI_File_sync(fh, ierr)
  integer, intent(inout) :: fh
  integer, intent(out) :: ierr
end subroutine MPI_File_sync

end interface


interface MPI_Finalize

subroutine MPI_Finalize(ierr)
  integer, intent(out) :: ierr
end subroutine MPI_Finalize

end interface


interface MPI_Finalized

subroutine MPI_Finalized(flag, ierr)
  logical, intent(out) :: flag
  integer, intent(out) :: ierr
end subroutine MPI_Finalized

end interface


interface MPI_Get_count

subroutine MPI_Get_count(status, datatype, count, ierr)
  include 'mpif-config.h'
  integer, dimension(MPI_STATUS_SIZE), intent(in) :: status
  integer, intent(in) :: datatype
  integer, intent(out) :: count
  integer, intent(out) :: ierr
end subroutine MPI_Get_count

end interface


interface MPI_Get_elements

subroutine MPI_Get_elements(status, datatype, count, ierr)
  include 'mpif-config.h'
  integer, dimension(MPI_STATUS_SIZE), intent(in) :: status
  integer, intent(in) :: datatype
  integer, intent(out) :: count
  integer, intent(out) :: ierr
end subroutine MPI_Get_elements

end interface


interface MPI_Get_processor_name

subroutine MPI_Get_processor_name(name, resultlen, ierr)
  character(len=*), intent(out) :: name
  integer, intent(out) :: resultlen
  integer, intent(out) :: ierr
end subroutine MPI_Get_processor_name

end interface


interface MPI_Get_version

subroutine MPI_Get_version(version, subversion, ierr)
  integer, intent(out) :: version
  integer, intent(out) :: subversion
  integer, intent(out) :: ierr
end subroutine MPI_Get_version

end interface


interface MPI_Graph_create

subroutine MPI_Graph_create(comm_old, nnodes, index, edges, reorder, &
        comm_graph, ierr)
  integer, intent(in) :: comm_old
  integer, intent(in) :: nnodes
  integer, dimension(*), intent(in) :: index
  integer, dimension(*), intent(in) :: edges
  logical, intent(in) :: reorder
  integer, intent(out) :: comm_graph
  integer, intent(out) :: ierr
end subroutine MPI_Graph_create

end interface


interface MPI_Graph_get

subroutine MPI_Graph_get(comm, maxindex, maxedges, index, edges&
        , ierr)
  integer, intent(in) :: comm
  integer, intent(in) :: maxindex
  integer, intent(in) :: maxedges
  integer, dimension(*), intent(out) :: index
  integer, dimension(*), intent(out) :: edges
  integer, intent(out) :: ierr
end subroutine MPI_Graph_get

end interface


interface MPI_Graph_map

subroutine MPI_Graph_map(comm, nnodes, index, edges, newrank&
        , ierr)
  integer, intent(in) :: comm
  integer, intent(in) :: nnodes
  integer, dimension(*), intent(in) :: index
  integer, dimension(*), intent(in) :: edges
  integer, intent(out) :: newrank
  integer, intent(out) :: ierr
end subroutine MPI_Graph_map

end interface


interface MPI_Graph_neighbors

subroutine MPI_Graph_neighbors(comm, rank, maxneighbors, neighbors, ierr)
  integer, intent(in) :: comm
  integer, intent(in) :: rank
  integer, intent(in) :: maxneighbors
  integer, dimension(*), intent(out) :: neighbors
  integer, intent(out) :: ierr
end subroutine MPI_Graph_neighbors

end interface


interface MPI_Graph_neighbors_count

subroutine MPI_Graph_neighbors_count(comm, rank, nneighbors, ierr)
  integer, intent(in) :: comm
  integer, intent(in) :: rank
  integer, intent(out) :: nneighbors
  integer, intent(out) :: ierr
end subroutine MPI_Graph_neighbors_count

end interface


interface MPI_Graphdims_get

subroutine MPI_Graphdims_get(comm, nnodes, nedges, ierr)
  integer, intent(in) :: comm
  integer, intent(out) :: nnodes
  integer, intent(out) :: nedges
  integer, intent(out) :: ierr
end subroutine MPI_Graphdims_get

end interface


interface MPI_Grequest_complete

subroutine MPI_Grequest_complete(request, ierr)
  integer, intent(inout) :: request
  integer, intent(out) :: ierr
end subroutine MPI_Grequest_complete

end interface


interface MPI_Grequest_start

subroutine MPI_Grequest_start(query_fn, free_fn, cancel_fn, extra_state, request&
        , ierr)
  include 'mpif-config.h'
  external :: query_fn
  external :: free_fn
  external :: cancel_fn
  integer(kind=MPI_ADDRESS_KIND), intent(in) :: extra_state
  integer, intent(out) :: request
  integer, intent(out) :: ierr
end subroutine MPI_Grequest_start

end interface


interface MPI_Group_compare

subroutine MPI_Group_compare(group1, group2, result, ierr)
  integer, intent(in) :: group1
  integer, intent(in) :: group2
  integer, intent(out) :: result
  integer, intent(out) :: ierr
end subroutine MPI_Group_compare

end interface


interface MPI_Group_difference

subroutine MPI_Group_difference(group1, group2, newgroup, ierr)
  integer, intent(in) :: group1
  integer, intent(in) :: group2
  integer, intent(out) :: newgroup
  integer, intent(out) :: ierr
end subroutine MPI_Group_difference

end interface


interface MPI_Group_excl

subroutine MPI_Group_excl(group, n, ranks, newgroup, ierr)
  integer, intent(in) :: group
  integer, intent(in) :: n
  integer, dimension(*), intent(in) :: ranks
  integer, intent(out) :: newgroup
  integer, intent(out) :: ierr
end subroutine MPI_Group_excl

end interface


interface MPI_Group_free

subroutine MPI_Group_free(group, ierr)
  integer, intent(inout) :: group
  integer, intent(out) :: ierr
end subroutine MPI_Group_free

end interface


interface MPI_Group_incl

subroutine MPI_Group_incl(group, n, ranks, newgroup, ierr)
  integer, intent(in) :: group
  integer, intent(in) :: n
  integer, dimension(*), intent(in) :: ranks
  integer, intent(out) :: newgroup
  integer, intent(out) :: ierr
end subroutine MPI_Group_incl

end interface


interface MPI_Group_intersection

subroutine MPI_Group_intersection(group1, group2, newgroup, ierr)
  integer, intent(in) :: group1
  integer, intent(in) :: group2
  integer, intent(out) :: newgroup
  integer, intent(out) :: ierr
end subroutine MPI_Group_intersection

end interface


interface MPI_Group_range_excl

subroutine MPI_Group_range_excl(group, n, ranges, newgroup, ierr)
  integer, intent(in) :: group
  integer, intent(in) :: n
  integer, dimension(3, *), intent(in) :: ranges
  integer, intent(out) :: newgroup
  integer, intent(out) :: ierr
end subroutine MPI_Group_range_excl

end interface


interface MPI_Group_range_incl

subroutine MPI_Group_range_incl(group, n, ranges, newgroup, ierr)
  integer, intent(in) :: group
  integer, intent(in) :: n
  integer, dimension(3, *), intent(in) :: ranges
  integer, intent(out) :: newgroup
  integer, intent(out) :: ierr
end subroutine MPI_Group_range_incl

end interface


interface MPI_Group_rank

subroutine MPI_Group_rank(group, rank, ierr)
  integer, intent(in) :: group
  integer, intent(out) :: rank
  integer, intent(out) :: ierr
end subroutine MPI_Group_rank

end interface


interface MPI_Group_size

subroutine MPI_Group_size(group, size, ierr)
  integer, intent(in) :: group
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Group_size

end interface


interface MPI_Group_translate_ranks

subroutine MPI_Group_translate_ranks(group1, n, ranks1, group2, ranks2&
        , ierr)
  integer, intent(in) :: group1
  integer, intent(in) :: n
  integer, dimension(*), intent(in) :: ranks1
  integer, intent(in) :: group2
  integer, dimension(*), intent(out) :: ranks2
  integer, intent(out) :: ierr
end subroutine MPI_Group_translate_ranks

end interface


interface MPI_Group_union

subroutine MPI_Group_union(group1, group2, newgroup, ierr)
  integer, intent(in) :: group1
  integer, intent(in) :: group2
  integer, intent(out) :: newgroup
  integer, intent(out) :: ierr
end subroutine MPI_Group_union

end interface


interface MPI_Info_create

subroutine MPI_Info_create(info, ierr)
  integer, intent(out) :: info
  integer, intent(out) :: ierr
end subroutine MPI_Info_create

end interface


interface MPI_Info_delete

subroutine MPI_Info_delete(info, key, ierr)
  integer, intent(out) :: info
  character(len=*), intent(in) :: key
  integer, intent(out) :: ierr
end subroutine MPI_Info_delete

end interface


interface MPI_Info_dup

subroutine MPI_Info_dup(info, newinfo, ierr)
  integer, intent(in) :: info
  integer, intent(out) :: newinfo
  integer, intent(out) :: ierr
end subroutine MPI_Info_dup

end interface


interface MPI_Info_free

subroutine MPI_Info_free(info, ierr)
  integer, intent(inout) :: info
  integer, intent(out) :: ierr
end subroutine MPI_Info_free

end interface


interface MPI_Info_get

subroutine MPI_Info_get(info, key, valuelen, value, flag&
        , ierr)
  integer, intent(in) :: info
  character(len=*), intent(in) :: key
  integer, intent(in) :: valuelen
  character(len=*), intent(out) :: value
  logical, intent(out) :: flag
  integer, intent(out) :: ierr
end subroutine MPI_Info_get

end interface


interface MPI_Info_get_nkeys

subroutine MPI_Info_get_nkeys(info, nkeys, ierr)
  integer, intent(in) :: info
  integer, intent(out) :: nkeys
  integer, intent(out) :: ierr
end subroutine MPI_Info_get_nkeys

end interface


interface MPI_Info_get_nthkey

subroutine MPI_Info_get_nthkey(info, n, key, ierr)
  integer, intent(in) :: info
  integer, intent(in) :: n
  character(len=*), intent(out) :: key
  integer, intent(out) :: ierr
end subroutine MPI_Info_get_nthkey

end interface


interface MPI_Info_get_valuelen

subroutine MPI_Info_get_valuelen(info, key, valuelen, flag, ierr)
  integer, intent(in) :: info
  character(len=*), intent(in) :: key
  integer, intent(out) :: valuelen
  logical, intent(out) :: flag
  integer, intent(out) :: ierr
end subroutine MPI_Info_get_valuelen

end interface


interface MPI_Info_set

subroutine MPI_Info_set(info, key, value, ierr)
  integer, intent(inout) :: info
  character(len=*), intent(in) :: key
  character(len=*), intent(in) :: value
  integer, intent(out) :: ierr
end subroutine MPI_Info_set

end interface


interface MPI_Init

subroutine MPI_Init(ierr)
  integer, intent(out) :: ierr
end subroutine MPI_Init

end interface


interface MPI_Init_thread

subroutine MPI_Init_thread(required, provided, ierr)
  integer, intent(in) :: required
  integer, intent(out) :: provided
  integer, intent(out) :: ierr
end subroutine MPI_Init_thread

end interface


interface MPI_Initialized

subroutine MPI_Initialized(flag, ierr)
  logical, intent(out) :: flag
  integer, intent(out) :: ierr
end subroutine MPI_Initialized

end interface


interface MPI_Intercomm_create

subroutine MPI_Intercomm_create(local_comm, local_leader, bridge_comm, remote_leader, tag, &
        newintercomm, ierr)
  integer, intent(in) :: local_comm
  integer, intent(in) :: local_leader
  integer, intent(in) :: bridge_comm
  integer, intent(in) :: remote_leader
  integer, intent(in) :: tag
  integer, intent(out) :: newintercomm
  integer, intent(out) :: ierr
end subroutine MPI_Intercomm_create

end interface


interface MPI_Intercomm_merge

subroutine MPI_Intercomm_merge(intercomm, high, newintercomm, ierr)
  integer, intent(in) :: intercomm
  logical, intent(in) :: high
  integer, intent(out) :: newintercomm
  integer, intent(out) :: ierr
end subroutine MPI_Intercomm_merge

end interface


interface MPI_Iprobe

subroutine MPI_Iprobe(source, tag, comm, flag, status&
        , ierr)
  include 'mpif-config.h'
  integer, intent(in) :: source
  integer, intent(in) :: tag
  integer, intent(in) :: comm
  logical, intent(out) :: flag
  integer, dimension(MPI_STATUS_SIZE), intent(out) :: status
  integer, intent(out) :: ierr
end subroutine MPI_Iprobe

end interface


interface MPI_Is_thread_main

subroutine MPI_Is_thread_main(flag, ierr)
  logical, intent(out) :: flag
  integer, intent(out) :: ierr
end subroutine MPI_Is_thread_main

end interface


interface MPI_Keyval_create

subroutine MPI_Keyval_create(copy_fn, delete_fn, keyval, extra_state, ierr)
  external :: copy_fn
  external :: delete_fn
  integer, intent(out) :: keyval
  integer, intent(in) :: extra_state
  integer, intent(out) :: ierr
end subroutine MPI_Keyval_create

end interface


interface MPI_Keyval_free

subroutine MPI_Keyval_free(keyval, ierr)
  integer, intent(inout) :: keyval
  integer, intent(out) :: ierr
end subroutine MPI_Keyval_free

end interface


interface MPI_Op_commutative

subroutine MPI_Op_commutative(op, commute, ierr)
  integer, intent(in) :: op
  logical, intent(out) :: commute
  integer, intent(out) :: ierr
end subroutine MPI_Op_commutative

end interface


interface MPI_Op_create

subroutine MPI_Op_create(function, commute, op, ierr)
  external :: function
  logical, intent(in) :: commute
  integer, intent(out) :: op
  integer, intent(out) :: ierr
end subroutine MPI_Op_create

end interface


interface MPI_Op_free

subroutine MPI_Op_free(op, ierr)
  integer, intent(inout) :: op
  integer, intent(out) :: ierr
end subroutine MPI_Op_free

end interface


interface MPI_Pack_external_size

subroutine MPI_Pack_external_size(datarep, incount, datatype, size, ierr)
  include 'mpif-config.h'
  character(len=*), intent(in) :: datarep
  integer, intent(in) :: incount
  integer, intent(in) :: datatype
  integer(kind=MPI_ADDRESS_KIND), intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Pack_external_size

end interface


interface MPI_Pack_size

subroutine MPI_Pack_size(incount, datatype, comm, size, ierr)
  integer, intent(in) :: incount
  integer, intent(in) :: datatype
  integer, intent(in) :: comm
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Pack_size

end interface


interface MPI_Pcontrol

subroutine MPI_Pcontrol(level)
  integer, intent(in) :: level

end subroutine MPI_Pcontrol

end interface


interface MPI_Probe

subroutine MPI_Probe(source, tag, comm, status, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: source
  integer, intent(in) :: tag
  integer, intent(in) :: comm
  integer, dimension(MPI_STATUS_SIZE), intent(out) :: status
  integer, intent(out) :: ierr
end subroutine MPI_Probe

end interface


interface MPI_Query_thread

subroutine MPI_Query_thread(provided, ierr)
  integer, intent(out) :: provided
  integer, intent(out) :: ierr
end subroutine MPI_Query_thread

end interface


interface MPI_Register_datarep

subroutine MPI_Register_datarep(datarep, read_conversion_fn, write_conversion_fn, dtype_file_extent_fn, extra_state&
        , ierr)
  include 'mpif-config.h'
  character(len=*), intent(in) :: datarep
  external :: read_conversion_fn
  external :: write_conversion_fn
  external :: dtype_file_extent_fn
  integer(kind=MPI_ADDRESS_KIND), intent(in) :: extra_state
  integer, intent(out) :: ierr
end subroutine MPI_Register_datarep

end interface


interface MPI_Request_free

subroutine MPI_Request_free(request, ierr)
  integer, intent(inout) :: request
  integer, intent(out) :: ierr
end subroutine MPI_Request_free

end interface


interface MPI_Request_get_status

subroutine MPI_Request_get_status(request, flag, status, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: request
  logical, intent(out) :: flag
  integer, dimension(MPI_STATUS_SIZE), intent(out) :: status
  integer, intent(out) :: ierr
end subroutine MPI_Request_get_status

end interface


interface MPI_Sizeof

subroutine MPI_Sizeof0DCH(x, size, ierr)
  character, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof0DCH


subroutine MPI_Sizeof0DL(x, size, ierr)
  logical, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof0DL


subroutine MPI_Sizeof0DI1(x, size, ierr)
  integer*1, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof0DI1


subroutine MPI_Sizeof0DI2(x, size, ierr)
  integer*2, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof0DI2


subroutine MPI_Sizeof0DI4(x, size, ierr)
  integer*4, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof0DI4


subroutine MPI_Sizeof0DI8(x, size, ierr)
  integer*8, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof0DI8


subroutine MPI_Sizeof0DR4(x, size, ierr)
  real*4, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof0DR4


subroutine MPI_Sizeof0DR8(x, size, ierr)
  real*8, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof0DR8


subroutine MPI_Sizeof0DR16(x, size, ierr)
  real*16, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof0DR16


subroutine MPI_Sizeof0DC8(x, size, ierr)
  complex*8, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof0DC8


subroutine MPI_Sizeof0DC16(x, size, ierr)
  complex*16, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof0DC16


subroutine MPI_Sizeof0DC32(x, size, ierr)
  complex*32, intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof0DC32


subroutine MPI_Sizeof1DCH(x, size, ierr)
  character, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof1DCH


subroutine MPI_Sizeof1DL(x, size, ierr)
  logical, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof1DL


subroutine MPI_Sizeof1DI1(x, size, ierr)
  integer*1, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof1DI1


subroutine MPI_Sizeof1DI2(x, size, ierr)
  integer*2, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof1DI2


subroutine MPI_Sizeof1DI4(x, size, ierr)
  integer*4, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof1DI4


subroutine MPI_Sizeof1DI8(x, size, ierr)
  integer*8, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof1DI8


subroutine MPI_Sizeof1DR4(x, size, ierr)
  real*4, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof1DR4


subroutine MPI_Sizeof1DR8(x, size, ierr)
  real*8, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof1DR8


subroutine MPI_Sizeof1DR16(x, size, ierr)
  real*16, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof1DR16


subroutine MPI_Sizeof1DC8(x, size, ierr)
  complex*8, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof1DC8


subroutine MPI_Sizeof1DC16(x, size, ierr)
  complex*16, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof1DC16


subroutine MPI_Sizeof1DC32(x, size, ierr)
  complex*32, dimension(*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof1DC32


subroutine MPI_Sizeof2DCH(x, size, ierr)
  character, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof2DCH


subroutine MPI_Sizeof2DL(x, size, ierr)
  logical, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof2DL


subroutine MPI_Sizeof2DI1(x, size, ierr)
  integer*1, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof2DI1


subroutine MPI_Sizeof2DI2(x, size, ierr)
  integer*2, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof2DI2


subroutine MPI_Sizeof2DI4(x, size, ierr)
  integer*4, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof2DI4


subroutine MPI_Sizeof2DI8(x, size, ierr)
  integer*8, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof2DI8


subroutine MPI_Sizeof2DR4(x, size, ierr)
  real*4, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof2DR4


subroutine MPI_Sizeof2DR8(x, size, ierr)
  real*8, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof2DR8


subroutine MPI_Sizeof2DR16(x, size, ierr)
  real*16, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof2DR16


subroutine MPI_Sizeof2DC8(x, size, ierr)
  complex*8, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof2DC8


subroutine MPI_Sizeof2DC16(x, size, ierr)
  complex*16, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof2DC16


subroutine MPI_Sizeof2DC32(x, size, ierr)
  complex*32, dimension(1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof2DC32


subroutine MPI_Sizeof3DCH(x, size, ierr)
  character, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof3DCH


subroutine MPI_Sizeof3DL(x, size, ierr)
  logical, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof3DL


subroutine MPI_Sizeof3DI1(x, size, ierr)
  integer*1, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof3DI1


subroutine MPI_Sizeof3DI2(x, size, ierr)
  integer*2, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof3DI2


subroutine MPI_Sizeof3DI4(x, size, ierr)
  integer*4, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof3DI4


subroutine MPI_Sizeof3DI8(x, size, ierr)
  integer*8, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof3DI8


subroutine MPI_Sizeof3DR4(x, size, ierr)
  real*4, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof3DR4


subroutine MPI_Sizeof3DR8(x, size, ierr)
  real*8, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof3DR8


subroutine MPI_Sizeof3DR16(x, size, ierr)
  real*16, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof3DR16


subroutine MPI_Sizeof3DC8(x, size, ierr)
  complex*8, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof3DC8


subroutine MPI_Sizeof3DC16(x, size, ierr)
  complex*16, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof3DC16


subroutine MPI_Sizeof3DC32(x, size, ierr)
  complex*32, dimension(1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof3DC32


subroutine MPI_Sizeof4DCH(x, size, ierr)
  character, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof4DCH


subroutine MPI_Sizeof4DL(x, size, ierr)
  logical, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof4DL


subroutine MPI_Sizeof4DI1(x, size, ierr)
  integer*1, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof4DI1


subroutine MPI_Sizeof4DI2(x, size, ierr)
  integer*2, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof4DI2


subroutine MPI_Sizeof4DI4(x, size, ierr)
  integer*4, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof4DI4


subroutine MPI_Sizeof4DI8(x, size, ierr)
  integer*8, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof4DI8


subroutine MPI_Sizeof4DR4(x, size, ierr)
  real*4, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof4DR4


subroutine MPI_Sizeof4DR8(x, size, ierr)
  real*8, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof4DR8


subroutine MPI_Sizeof4DR16(x, size, ierr)
  real*16, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof4DR16


subroutine MPI_Sizeof4DC8(x, size, ierr)
  complex*8, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof4DC8


subroutine MPI_Sizeof4DC16(x, size, ierr)
  complex*16, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof4DC16


subroutine MPI_Sizeof4DC32(x, size, ierr)
  complex*32, dimension(1,1,1,*), intent(in) :: x
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Sizeof4DC32

end interface


interface MPI_Start

subroutine MPI_Start(request, ierr)
  integer, intent(inout) :: request
  integer, intent(out) :: ierr
end subroutine MPI_Start

end interface


interface MPI_Startall

subroutine MPI_Startall(count, array_of_requests, ierr)
  integer, intent(in) :: count
  integer, dimension(*), intent(inout) :: array_of_requests
  integer, intent(out) :: ierr
end subroutine MPI_Startall

end interface


interface MPI_Status_set_cancelled

subroutine MPI_Status_set_cancelled(status, flag, ierr)
  include 'mpif-config.h'
  integer, dimension(MPI_STATUS_SIZE), intent(inout) :: status
  logical, intent(in) :: flag
  integer, intent(out) :: ierr
end subroutine MPI_Status_set_cancelled

end interface


interface MPI_Status_set_elements

subroutine MPI_Status_set_elements(status, datatype, count, ierr)
  include 'mpif-config.h'
  integer, dimension(MPI_STATUS_SIZE), intent(inout) :: status
  integer, intent(in) :: datatype
  integer, intent(in) :: count
  integer, intent(out) :: ierr
end subroutine MPI_Status_set_elements

end interface


interface MPI_Test

subroutine MPI_Test(request, flag, status, ierr)
  include 'mpif-config.h'
  integer, intent(inout) :: request
  logical, intent(out) :: flag
  integer, dimension(MPI_STATUS_SIZE), intent(out) :: status
  integer, intent(out) :: ierr
end subroutine MPI_Test

end interface


interface MPI_Test_cancelled

subroutine MPI_Test_cancelled(status, flag, ierr)
  include 'mpif-config.h'
  integer, dimension(MPI_STATUS_SIZE), intent(in) :: status
  logical, intent(out) :: flag
  integer, intent(out) :: ierr
end subroutine MPI_Test_cancelled

end interface


interface MPI_Testall

subroutine MPI_TestallS(count, array_of_requests, flag, array_of_statuses, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: count
  integer, dimension(count), intent(inout) :: array_of_requests
  logical, intent(out) :: flag
  integer, dimension(MPI_STATUS_SIZE, count), intent(out) :: array_of_statuses
  integer, intent(out) :: ierr
end subroutine MPI_TestallS


subroutine MPI_TestallI(count, array_of_requests, flag, array_of_statuses, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: count
  integer, dimension(count), intent(inout) :: array_of_requests
  logical, intent(out) :: flag
  double precision, intent(out) :: array_of_statuses
  integer, intent(out) :: ierr
end subroutine MPI_TestallI

end interface


interface MPI_Testany

subroutine MPI_Testany(count, array_of_requests, index, flag, status&
        , ierr)
  include 'mpif-config.h'
  integer, intent(in) :: count
  integer, dimension(count), intent(inout) :: array_of_requests
  integer, intent(out) :: index
  logical, intent(out) :: flag
  integer, dimension(MPI_STATUS_SIZE), intent(out) :: status
  integer, intent(out) :: ierr
end subroutine MPI_Testany

end interface


interface MPI_Testsome

subroutine MPI_TestsomeS(incount, array_of_requests, outcount, array_of_indices, array_of_statuses&
        , ierr)
  include 'mpif-config.h'
  integer, intent(in) :: incount
  integer, dimension(incount), intent(inout) :: array_of_requests
  integer, intent(out) :: outcount
  integer, dimension(*), intent(out) :: array_of_indices
  integer, dimension(MPI_STATUS_SIZE, incount), intent(out) :: array_of_statuses
  integer, intent(out) :: ierr
end subroutine MPI_TestsomeS


subroutine MPI_TestsomeI(incount, array_of_requests, outcount, array_of_indices, array_of_statuses&
        , ierr)
  include 'mpif-config.h'
  integer, intent(in) :: incount
  integer, dimension(incount), intent(inout) :: array_of_requests
  integer, intent(out) :: outcount
  integer, dimension(*), intent(out) :: array_of_indices
  double precision, intent(out) :: array_of_statuses
  integer, intent(out) :: ierr
end subroutine MPI_TestsomeI

end interface


interface MPI_Topo_test

subroutine MPI_Topo_test(comm, status, ierr)
  integer, intent(in) :: comm
  integer, intent(out) :: status
  integer, intent(out) :: ierr
end subroutine MPI_Topo_test

end interface


interface MPI_Type_commit

subroutine MPI_Type_commit(type, ierr)
  integer, intent(inout) :: type
  integer, intent(out) :: ierr
end subroutine MPI_Type_commit

end interface


interface MPI_Type_contiguous

subroutine MPI_Type_contiguous(count, oldtype, newtype, ierr)
  integer, intent(in) :: count
  integer, intent(in) :: oldtype
  integer, intent(out) :: newtype
  integer, intent(out) :: ierr
end subroutine MPI_Type_contiguous

end interface


interface MPI_Type_create_darray

subroutine MPI_Type_create_darray(size, rank, ndims, gsize_array, distrib_array, &
        darg_array, psize_array, order, oldtype, newtype, ierr)
  integer, intent(in) :: size
  integer, intent(in) :: rank
  integer, intent(in) :: ndims
  integer, dimension(*), intent(in) :: gsize_array
  integer, dimension(*), intent(in) :: distrib_array
  integer, dimension(*), intent(in) :: darg_array
  integer, dimension(*), intent(in) :: psize_array
  integer, intent(in) :: order
  integer, intent(in) :: oldtype
  integer, intent(out) :: newtype
  integer, intent(out) :: ierr
end subroutine MPI_Type_create_darray

end interface


interface MPI_Type_create_f90_complex

subroutine MPI_Type_create_f90_complex(p, r, newtype, ierr)
  integer, intent(in) :: p
  integer, intent(in) :: r
  integer, intent(out) :: newtype
  integer, intent(out) :: ierr
end subroutine MPI_Type_create_f90_complex

end interface


interface MPI_Type_create_f90_integer

subroutine MPI_Type_create_f90_integer(r, newtype, ierr)
  integer, intent(in) :: r
  integer, intent(out) :: newtype
  integer, intent(out) :: ierr
end subroutine MPI_Type_create_f90_integer

end interface


interface MPI_Type_create_f90_real

subroutine MPI_Type_create_f90_real(p, r, newtype, ierr)
  integer, intent(in) :: p
  integer, intent(in) :: r
  integer, intent(out) :: newtype
  integer, intent(out) :: ierr
end subroutine MPI_Type_create_f90_real

end interface


interface MPI_Type_create_hindexed

subroutine MPI_Type_create_hindexed(count, array_of_blocklengths, array_of_displacements, oldtype, newtype&
        , ierr)
  include 'mpif-config.h'
  integer, intent(in) :: count
  integer, dimension(*), intent(in) :: array_of_blocklengths
  integer(kind=MPI_ADDRESS_KIND), dimension(*), intent(in) :: array_of_displacements
  integer, intent(in) :: oldtype
  integer, intent(out) :: newtype
  integer, intent(out) :: ierr
end subroutine MPI_Type_create_hindexed

end interface


interface MPI_Type_create_hvector

subroutine MPI_Type_create_hvector(count, blocklength, stride, oldtype, newtype&
        , ierr)
  include 'mpif-config.h'
  integer, intent(in) :: count
  integer, intent(in) :: blocklength
  integer(kind=MPI_ADDRESS_KIND), intent(in) :: stride
  integer, intent(in) :: oldtype
  integer, intent(out) :: newtype
  integer, intent(out) :: ierr
end subroutine MPI_Type_create_hvector

end interface


interface MPI_Type_create_indexed_block

subroutine MPI_Type_create_indexed_block(count, blocklength, array_of_displacements, oldtype, newtype&
        , ierr)
  integer, intent(in) :: count
  integer, intent(in) :: blocklength
  integer, dimension(*), intent(in) :: array_of_displacements
  integer, intent(in) :: oldtype
  integer, intent(out) :: newtype
  integer, intent(out) :: ierr
end subroutine MPI_Type_create_indexed_block

end interface


interface MPI_Type_create_keyval

subroutine MPI_Type_create_keyval(type_copy_attr_fn, type_delete_attr_fn, type_keyval, extra_state, ierr)
  include 'mpif-config.h'
  external :: type_copy_attr_fn
  external :: type_delete_attr_fn
  integer, intent(out) :: type_keyval
  integer(kind=MPI_ADDRESS_KIND), intent(in) :: extra_state
  integer, intent(out) :: ierr
end subroutine MPI_Type_create_keyval

end interface


interface MPI_Type_create_resized

subroutine MPI_Type_create_resized(oldtype, lb, extent, newtype, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: oldtype
  integer(kind=MPI_ADDRESS_KIND), intent(in) :: lb
  integer(kind=MPI_ADDRESS_KIND), intent(in) :: extent
  integer, intent(out) :: newtype
  integer, intent(out) :: ierr
end subroutine MPI_Type_create_resized

end interface


interface MPI_Type_create_struct

subroutine MPI_Type_create_struct(count, array_of_block_lengths, array_of_displacements, array_of_types, newtype&
        , ierr)
  include 'mpif-config.h'
  integer, intent(in) :: count
  integer, dimension(*), intent(in) :: array_of_block_lengths
  integer(kind=MPI_ADDRESS_KIND), dimension(*), intent(in) :: array_of_displacements
  integer, dimension(*), intent(in) :: array_of_types
  integer, intent(out) :: newtype
  integer, intent(out) :: ierr
end subroutine MPI_Type_create_struct

end interface


interface MPI_Type_create_subarray

subroutine MPI_Type_create_subarray(ndims, size_array, subsize_array, start_array, order, &
        oldtype, newtype, ierr)
  integer, intent(in) :: ndims
  integer, dimension(*), intent(in) :: size_array
  integer, dimension(*), intent(in) :: subsize_array
  integer, dimension(*), intent(in) :: start_array
  integer, intent(in) :: order
  integer, intent(in) :: oldtype
  integer, intent(out) :: newtype
  integer, intent(out) :: ierr
end subroutine MPI_Type_create_subarray

end interface


interface MPI_Type_delete_attr

subroutine MPI_Type_delete_attr(type, type_keyval, ierr)
  integer, intent(inout) :: type
  integer, intent(in) :: type_keyval
  integer, intent(out) :: ierr
end subroutine MPI_Type_delete_attr

end interface


interface MPI_Type_dup

subroutine MPI_Type_dup(type, newtype, ierr)
  integer, intent(in) :: type
  integer, intent(out) :: newtype
  integer, intent(out) :: ierr
end subroutine MPI_Type_dup

end interface


interface MPI_Type_extent

subroutine MPI_Type_extent(type, extent, ierr)
  integer, intent(in) :: type
  integer, intent(out) :: extent
  integer, intent(out) :: ierr
end subroutine MPI_Type_extent

end interface


interface MPI_Type_free

subroutine MPI_Type_free(type, ierr)
  integer, intent(inout) :: type
  integer, intent(out) :: ierr
end subroutine MPI_Type_free

end interface


interface MPI_Type_free_keyval

subroutine MPI_Type_free_keyval(type_keyval, ierr)
  integer, intent(inout) :: type_keyval
  integer, intent(out) :: ierr
end subroutine MPI_Type_free_keyval

end interface


interface MPI_Type_get_attr

subroutine MPI_Type_get_attr(type, type_keyval, attribute_val, flag, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: type
  integer, intent(in) :: type_keyval
  integer(kind=MPI_ADDRESS_KIND), intent(out) :: attribute_val
  logical, intent(out) :: flag
  integer, intent(out) :: ierr
end subroutine MPI_Type_get_attr

end interface


interface MPI_Type_get_contents

subroutine MPI_Type_get_contents(mtype, max_integers, max_addresses, max_datatypes, array_of_integers, &
        array_of_addresses, array_of_datatypes, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: mtype
  integer, intent(in) :: max_integers
  integer, intent(in) :: max_addresses
  integer, intent(in) :: max_datatypes
  integer, dimension(*), intent(out) :: array_of_integers
  integer(kind=MPI_ADDRESS_KIND), dimension(*), intent(out) :: array_of_addresses
  integer, dimension(*), intent(out) :: array_of_datatypes
  integer, intent(out) :: ierr
end subroutine MPI_Type_get_contents

end interface


interface MPI_Type_get_envelope

subroutine MPI_Type_get_envelope(type, num_integers, num_addresses, num_datatypes, combiner&
        , ierr)
  integer, intent(in) :: type
  integer, intent(out) :: num_integers
  integer, intent(out) :: num_addresses
  integer, intent(out) :: num_datatypes
  integer, intent(out) :: combiner
  integer, intent(out) :: ierr
end subroutine MPI_Type_get_envelope

end interface


interface MPI_Type_get_extent

subroutine MPI_Type_get_extent(type, lb, extent, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: type
  integer(kind=MPI_ADDRESS_KIND), intent(out) :: lb
  integer(kind=MPI_ADDRESS_KIND), intent(out) :: extent
  integer, intent(out) :: ierr
end subroutine MPI_Type_get_extent

end interface


interface MPI_Type_get_name

subroutine MPI_Type_get_name(type, type_name, resultlen, ierr)
  integer, intent(in) :: type
  character(len=*), intent(out) :: type_name
  integer, intent(out) :: resultlen
  integer, intent(out) :: ierr
end subroutine MPI_Type_get_name

end interface


interface MPI_Type_get_true_extent

subroutine MPI_Type_get_true_extent(datatype, true_lb, true_extent, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: datatype
  integer(kind=MPI_ADDRESS_KIND), intent(out) :: true_lb
  integer(kind=MPI_ADDRESS_KIND), intent(out) :: true_extent
  integer, intent(out) :: ierr
end subroutine MPI_Type_get_true_extent

end interface


interface MPI_Type_hindexed

subroutine MPI_Type_hindexed(count, array_of_blocklengths, array_of_displacements, oldtype, newtype&
        , ierr)
  integer, intent(in) :: count
  integer, dimension(*), intent(in) :: array_of_blocklengths
  integer, dimension(*), intent(in) :: array_of_displacements
  integer, intent(in) :: oldtype
  integer, intent(out) :: newtype
  integer, intent(out) :: ierr
end subroutine MPI_Type_hindexed

end interface


interface MPI_Type_hvector

subroutine MPI_Type_hvector(count, blocklength, stride, oldtype, newtype&
        , ierr)
  integer, intent(in) :: count
  integer, intent(in) :: blocklength
  integer, intent(in) :: stride
  integer, intent(in) :: oldtype
  integer, intent(out) :: newtype
  integer, intent(out) :: ierr
end subroutine MPI_Type_hvector

end interface


interface MPI_Type_indexed

subroutine MPI_Type_indexed(count, array_of_blocklengths, array_of_displacements, oldtype, newtype&
        , ierr)
  integer, intent(in) :: count
  integer, dimension(*), intent(in) :: array_of_blocklengths
  integer, dimension(*), intent(in) :: array_of_displacements
  integer, intent(in) :: oldtype
  integer, intent(out) :: newtype
  integer, intent(out) :: ierr
end subroutine MPI_Type_indexed

end interface


interface MPI_Type_lb

subroutine MPI_Type_lb(type, lb, ierr)
  integer, intent(in) :: type
  integer, intent(out) :: lb
  integer, intent(out) :: ierr
end subroutine MPI_Type_lb

end interface


interface MPI_Type_match_size

subroutine MPI_Type_match_size(typeclass, size, type, ierr)
  integer, intent(in) :: typeclass
  integer, intent(in) :: size
  integer, intent(out) :: type
  integer, intent(out) :: ierr
end subroutine MPI_Type_match_size

end interface


interface MPI_Type_set_attr

subroutine MPI_Type_set_attr(type, type_keyval, attr_val, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: type
  integer, intent(in) :: type_keyval
  integer(kind=MPI_ADDRESS_KIND), intent(in) :: attr_val
  integer, intent(out) :: ierr
end subroutine MPI_Type_set_attr

end interface


interface MPI_Type_set_name

subroutine MPI_Type_set_name(type, type_name, ierr)
  integer, intent(inout) :: type
  character(len=*), intent(in) :: type_name
  integer, intent(out) :: ierr
end subroutine MPI_Type_set_name

end interface


interface MPI_Type_size

subroutine MPI_Type_size(type, size, ierr)
  integer, intent(in) :: type
  integer, intent(out) :: size
  integer, intent(out) :: ierr
end subroutine MPI_Type_size

end interface


interface MPI_Type_struct

subroutine MPI_Type_struct(count, array_of_blocklengths, array_of_displacements, array_of_types, newtype&
        , ierr)
  integer, intent(in) :: count
  integer, dimension(*), intent(in) :: array_of_blocklengths
  integer, dimension(*), intent(in) :: array_of_displacements
  integer, dimension(*), intent(in) :: array_of_types
  integer, intent(out) :: newtype
  integer, intent(out) :: ierr
end subroutine MPI_Type_struct

end interface


interface MPI_Type_ub

subroutine MPI_Type_ub(mtype, ub, ierr)
  integer, intent(in) :: mtype
  integer, intent(out) :: ub
  integer, intent(out) :: ierr
end subroutine MPI_Type_ub

end interface


interface MPI_Type_vector

subroutine MPI_Type_vector(count, blocklength, stride, oldtype, newtype&
        , ierr)
  integer, intent(in) :: count
  integer, intent(in) :: blocklength
  integer, intent(in) :: stride
  integer, intent(in) :: oldtype
  integer, intent(out) :: newtype
  integer, intent(out) :: ierr
end subroutine MPI_Type_vector

end interface


interface MPI_Wait

subroutine MPI_Wait(request, status, ierr)
  include 'mpif-config.h'
  integer, intent(inout) :: request
  integer, dimension(MPI_STATUS_SIZE), intent(out) :: status
  integer, intent(out) :: ierr
end subroutine MPI_Wait

end interface


interface MPI_Waitall

subroutine MPI_WaitallS(count, array_of_requests, array_of_statuses, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: count
  integer, dimension(count), intent(inout) :: array_of_requests
  integer, dimension(MPI_STATUS_SIZE, count), intent(out) :: array_of_statuses
  integer, intent(out) :: ierr
end subroutine MPI_WaitallS


subroutine MPI_WaitallI(count, array_of_requests, array_of_statuses, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: count
  integer, dimension(count), intent(inout) :: array_of_requests
  double precision, intent(out) :: array_of_statuses
  integer, intent(out) :: ierr
end subroutine MPI_WaitallI

end interface


interface MPI_Waitany

subroutine MPI_Waitany(count, array_of_requests, index, status, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: count
  integer, dimension(count), intent(inout) :: array_of_requests
  integer, intent(out) :: index
  integer, dimension(MPI_STATUS_SIZE), intent(out) :: status
  integer, intent(out) :: ierr
end subroutine MPI_Waitany

end interface


interface MPI_Waitsome

subroutine MPI_WaitsomeS(incount, array_of_requests, outcount, array_of_indices, array_of_statuses&
        , ierr)
  include 'mpif-config.h'
  integer, intent(in) :: incount
  integer, dimension(incount), intent(inout) :: array_of_requests
  integer, intent(out) :: outcount
  integer, dimension(*), intent(out) :: array_of_indices
  integer, dimension(MPI_STATUS_SIZE, incount), intent(out) :: array_of_statuses
  integer, intent(out) :: ierr
end subroutine MPI_WaitsomeS


subroutine MPI_WaitsomeI(incount, array_of_requests, outcount, array_of_indices, array_of_statuses&
        , ierr)
  include 'mpif-config.h'
  integer, intent(in) :: incount
  integer, dimension(incount), intent(inout) :: array_of_requests
  integer, intent(out) :: outcount
  integer, dimension(*), intent(out) :: array_of_indices
  double precision, intent(out) :: array_of_statuses
  integer, intent(out) :: ierr
end subroutine MPI_WaitsomeI

end interface


interface MPI_Win_call_errhandler

subroutine MPI_Win_call_errhandler(win, errorcode, ierr)
  integer, intent(in) :: win
  integer, intent(in) :: errorcode
  integer, intent(out) :: ierr
end subroutine MPI_Win_call_errhandler

end interface


interface MPI_Win_complete

subroutine MPI_Win_complete(win, ierr)
  integer, intent(in) :: win
  integer, intent(out) :: ierr
end subroutine MPI_Win_complete

end interface


interface MPI_Win_create_errhandler

subroutine MPI_Win_create_errhandler(function, errhandler, ierr)
  external :: function
  integer, intent(out) :: errhandler
  integer, intent(out) :: ierr
end subroutine MPI_Win_create_errhandler

end interface


interface MPI_Win_create_keyval

subroutine MPI_Win_create_keyval(win_copy_attr_fn, win_delete_attr_fn, win_keyval, extra_state, ierr)
  include 'mpif-config.h'
  external :: win_copy_attr_fn
  external :: win_delete_attr_fn
  integer, intent(out) :: win_keyval
  integer(kind=MPI_ADDRESS_KIND), intent(in) :: extra_state
  integer, intent(out) :: ierr
end subroutine MPI_Win_create_keyval

end interface


interface MPI_Win_delete_attr

subroutine MPI_Win_delete_attr(win, win_keyval, ierr)
  integer, intent(inout) :: win
  integer, intent(in) :: win_keyval
  integer, intent(out) :: ierr
end subroutine MPI_Win_delete_attr

end interface


interface MPI_Win_fence

subroutine MPI_Win_fence(assert, win, ierr)
  integer, intent(in) :: assert
  integer, intent(in) :: win
  integer, intent(out) :: ierr
end subroutine MPI_Win_fence

end interface


interface MPI_Win_free

subroutine MPI_Win_free(win, ierr)
  integer, intent(inout) :: win
  integer, intent(out) :: ierr
end subroutine MPI_Win_free

end interface


interface MPI_Win_free_keyval

subroutine MPI_Win_free_keyval(win_keyval, ierr)
  integer, intent(inout) :: win_keyval
  integer, intent(out) :: ierr
end subroutine MPI_Win_free_keyval

end interface


interface MPI_Win_get_attr

subroutine MPI_Win_get_attr(win, win_keyval, attribute_val, flag, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: win
  integer, intent(in) :: win_keyval
  integer(kind=MPI_ADDRESS_KIND), intent(out) :: attribute_val
  logical, intent(out) :: flag
  integer, intent(out) :: ierr
end subroutine MPI_Win_get_attr

end interface


interface MPI_Win_get_errhandler

subroutine MPI_Win_get_errhandler(win, errhandler, ierr)
  integer, intent(in) :: win
  integer, intent(out) :: errhandler
  integer, intent(out) :: ierr
end subroutine MPI_Win_get_errhandler

end interface


interface MPI_Win_get_group

subroutine MPI_Win_get_group(win, group, ierr)
  integer, intent(in) :: win
  integer, intent(out) :: group
  integer, intent(out) :: ierr
end subroutine MPI_Win_get_group

end interface


interface MPI_Win_get_name

subroutine MPI_Win_get_name(win, win_name, resultlen, ierr)
  integer, intent(in) :: win
  character(len=*), intent(out) :: win_name
  integer, intent(out) :: resultlen
  integer, intent(out) :: ierr
end subroutine MPI_Win_get_name

end interface


interface MPI_Win_lock

subroutine MPI_Win_lock(lock_type, rank, assert, win, ierr)
  integer, intent(in) :: lock_type
  integer, intent(in) :: rank
  integer, intent(in) :: assert
  integer, intent(in) :: win
  integer, intent(out) :: ierr
end subroutine MPI_Win_lock

end interface


interface MPI_Win_post

subroutine MPI_Win_post(group, assert, win, ierr)
  integer, intent(in) :: group
  integer, intent(in) :: assert
  integer, intent(in) :: win
  integer, intent(out) :: ierr
end subroutine MPI_Win_post

end interface


interface MPI_Win_set_attr

subroutine MPI_Win_set_attr(win, win_keyval, attribute_val, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: win
  integer, intent(in) :: win_keyval
  integer(kind=MPI_ADDRESS_KIND), intent(in) :: attribute_val
  integer, intent(out) :: ierr
end subroutine MPI_Win_set_attr

end interface


interface MPI_Win_set_errhandler

subroutine MPI_Win_set_errhandler(win, errhandler, ierr)
  integer, intent(in) :: win
  integer, intent(in) :: errhandler
  integer, intent(out) :: ierr
end subroutine MPI_Win_set_errhandler

end interface


interface MPI_Win_set_name

subroutine MPI_Win_set_name(win, win_name, ierr)
  integer, intent(inout) :: win
  character(len=*), intent(in) :: win_name
  integer, intent(out) :: ierr
end subroutine MPI_Win_set_name

end interface


interface MPI_Win_start

subroutine MPI_Win_start(group, assert, win, ierr)
  integer, intent(in) :: group
  integer, intent(in) :: assert
  integer, intent(in) :: win
  integer, intent(out) :: ierr
end subroutine MPI_Win_start

end interface


interface MPI_Win_test

subroutine MPI_Win_test(win, flag, ierr)
  integer, intent(in) :: win
  logical, intent(out) :: flag
  integer, intent(out) :: ierr
end subroutine MPI_Win_test

end interface


interface MPI_Win_unlock

subroutine MPI_Win_unlock(rank, win, ierr)
  integer, intent(in) :: rank
  integer, intent(in) :: win
  integer, intent(out) :: ierr
end subroutine MPI_Win_unlock

end interface


interface MPI_Win_wait

subroutine MPI_Win_wait(win, ierr)
  integer, intent(in) :: win
  integer, intent(out) :: ierr
end subroutine MPI_Win_wait

end interface


interface MPI_Close_port

subroutine MPI_Close_port(port_name, ierr)
  character(len=*), intent(in) :: port_name
  integer, intent(out) :: ierr
end subroutine MPI_Close_port

end interface


interface MPI_Lookup_name

subroutine MPI_Lookup_name(service_name, info, port_name, ierr)
  character(len=*), intent(in) :: service_name
  integer, intent(in) :: info
  character(len=*), intent(out) :: port_name
  integer, intent(out) :: ierr
end subroutine MPI_Lookup_name

end interface


interface MPI_Open_port

subroutine MPI_Open_port(info, port_name, ierr)
  integer, intent(in) :: info
  character(len=*), intent(out) :: port_name
  integer, intent(out) :: ierr
end subroutine MPI_Open_port

end interface


interface MPI_Publish_name

subroutine MPI_Publish_name(service_name, info, port_name, ierr)
  character(len=*), intent(in) :: service_name
  integer, intent(in) :: info
  character(len=*), intent(in) :: port_name
  integer, intent(out) :: ierr
end subroutine MPI_Publish_name

end interface


interface MPI_Unpublish_name

subroutine MPI_Unpublish_name(service_name, info, port_name, ierr)
  character(len=*), intent(in) :: service_name
  integer, intent(in) :: info
  character(len=*), intent(in) :: port_name
  integer, intent(out) :: ierr
end subroutine MPI_Unpublish_name

end interface


interface MPI_Comm_disconnect

subroutine MPI_Comm_disconnect(comm, ierr)
  integer, intent(inout) :: comm
  integer, intent(out) :: ierr
end subroutine MPI_Comm_disconnect

end interface


interface MPI_Comm_get_parent

subroutine MPI_Comm_get_parent(parent, ierr)
  integer, intent(out) :: parent
  integer, intent(out) :: ierr
end subroutine MPI_Comm_get_parent

end interface


interface MPI_Comm_join

subroutine MPI_Comm_join(fd, intercomm, ierr)
  integer, intent(in) :: fd
  integer, intent(out) :: intercomm
  integer, intent(out) :: ierr
end subroutine MPI_Comm_join

end interface


interface MPI_Comm_accept

subroutine MPI_Comm_accept(port_name, info, root, comm, newcomm&
        , ierr)
  character(len=*), intent(in) :: port_name
  integer, intent(in) :: info
  integer, intent(in) :: root
  integer, intent(in) :: comm
  integer, intent(out) :: newcomm
  integer, intent(out) :: ierr
end subroutine MPI_Comm_accept

end interface


interface MPI_Comm_connect

subroutine MPI_Comm_connect(port_name, info, root, comm, newcomm&
        , ierr)
  character(len=*), intent(in) :: port_name
  integer, intent(in) :: info
  integer, intent(in) :: root
  integer, intent(in) :: comm
  integer, intent(out) :: newcomm
  integer, intent(out) :: ierr
end subroutine MPI_Comm_connect

end interface


interface MPI_Comm_spawn

subroutine MPI_Comm_spawn(command, argv, maxprocs, info, root, &
        comm, intercomm, array_of_errcodes, ierr)
  character(len=*), intent(in) :: command
  character(len=*), dimension(*), intent(in) :: argv
  integer, intent(in) :: maxprocs
  integer, intent(in) :: info
  integer, intent(in) :: root
  integer, intent(in) :: comm
  integer, intent(out) :: intercomm
  integer, dimension(*), intent(out) :: array_of_errcodes
  integer, intent(out) :: ierr
end subroutine MPI_Comm_spawn

end interface


interface MPI_Comm_spawn_multiple

subroutine MPI_Comm_spawn_multipleA(count, array_of_commands, array_of_argv, array_of_maxprocs, array_of_info, &
        root, comm, intercomm, array_of_errcodes, ierr)
  integer, intent(in) :: count
  character(len=*), dimension(*), intent(in) :: array_of_commands
  character(len=*), dimension(count,*), intent(in) :: array_of_argv
  integer, dimension(*), intent(in) :: array_of_maxprocs
  integer, dimension(*), intent(in) :: array_of_info
  integer, intent(in) :: root
  integer, intent(in) :: comm
  integer, intent(out) :: intercomm
  integer, dimension(*), intent(out) :: array_of_errcodes
  integer, intent(out) :: ierr
end subroutine MPI_Comm_spawn_multipleA


subroutine MPI_Comm_spawn_multipleN(count, array_of_commands, array_of_argv, array_of_maxprocs, array_of_info, &
        root, comm, intercomm, array_of_errcodes, ierr)
  integer, intent(in) :: count
  character(len=*), dimension(*), intent(in) :: array_of_commands
  double precision, intent(in) :: array_of_argv
  integer, dimension(*), intent(in) :: array_of_maxprocs
  integer, dimension(*), intent(in) :: array_of_info
  integer, intent(in) :: root
  integer, intent(in) :: comm
  integer, intent(out) :: intercomm
  integer, dimension(*), intent(out) :: array_of_errcodes
  integer, intent(out) :: ierr
end subroutine MPI_Comm_spawn_multipleN

end interface


