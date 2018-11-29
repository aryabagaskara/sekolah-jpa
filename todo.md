## TODO

no HQL in updateWaliKelas yet

read batch hasn't been tried

figuring out cascade correctly xd


## Read

read kelas from murid ----- done

read kelas from wali kelas

read murid from kelas

read wali kelas from kelas ----- done

read wali kelas from murid ----- done


## Create
create kelas ----- done

create kelas together with wali kelas and murid assigned ----- done

create wali kelas and kelas together ----- done

Batch add murid to an existing class ----- done

push waliKelas to an existing one ----- done, error because waliKelas is unique


## Update

update namaMurid ----- done in HQL

update namaWaliKelas ----- done, no HQL yet

Update namaKelas ----- done in HQL

Update WaliKelas to a Kelas with no WaliKelas ----- fixed (maybe)

## Delete

Delete kelas ----- done, wali kelas and murid automatically deleted too

Delete murid ----- done, kelas not deleted

Delete walikelas ----- done retesting, behavior seems OK (might be not)


