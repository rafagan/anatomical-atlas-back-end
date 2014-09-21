
TRUNCATE BoneSet;
TRUNCATE Bone;
TRUNCATE BonePart;


INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (NULL,"Skeleton","Description",206);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (1,"Axial","Description",80);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (2,"Skull","Description",28);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber,Synonymous) VALUES (3,"Cranium","Description",8,"Braincase");

INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber,Synonymous) VALUES (4,"Skullcap","Description",6,"Calvaria");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (4,"Description","Sphenoid");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (4,"Description","Ethmoid");
INSERT INTO BonePart (Bone_idBone,Description,Name) VALUES (1,"Description","Left Cribform Plate");
INSERT INTO BonePart (Bone_idBone,Description,Name) VALUES (1,"Description","Right Cribform Plate");
INSERT INTO BonePart (Bone_idBone,Description,Name) VALUES (1,"Description","Perpendicular Plate");
INSERT INTO BonePart (Bone_idBone,Description,Name) VALUES (1,"Description","Ethmoid");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (5,"Description","Frontal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (5,"Description","Left Parietal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (5,"Description","Right Parietal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (5,"Description","Occipital");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (5,"Description","Left Temporal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (5,"Description","Right Temporal");

INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (3,"Facial Skeleton","Description",14);
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (6,"Description","Left Zygomatic");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (6,"Description","Right Zygomatic");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name,Synonymous) VALUES (6,"Description","Left Maxillary","Left Maxilla");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name,Synonymous) VALUES (6,"Description","Right Maxillary","Right Maxilla");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (6,"Description","Mandible");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (6,"Description","Left Nasal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (6,"Description","Right Nasal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (6,"Description","Vomer");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (6,"Description","Left Lacrimal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (6,"Description","Right Lacrimal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (6,"Description","Left Palatine");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (6,"Description","Right Palatine");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (6,"Description","Left Inferior Nasal Concha");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (6,"Description","Right Inferior Nasal Concha");


INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (3,"Auditory Ossicles","Description",6);
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (7,"Description","Left Malleus");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (7,"Description","Right Malleus");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (7,"Description","Left Incus");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (7,"Description","Right Incus");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (7,"Description","Left Stapes");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (7,"Description","Right Stapes");


INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (2,"Laryngeal Skeleton","Description",1);
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name,Synonymous) VALUES (8,"Description","Hyoid","Lingual Bone");
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,Synonymous,BoneNumber) VALUES (2,"Torso","Description","Chest",51);
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name,Synonymous) VALUES (9,"Description","Sternum","Breastbone");
INSERT INTO BonePart (Bone_idBone,Description,Name) VALUES (30,"Description","Manubrium");
INSERT INTO BonePart (Bone_idBone,Description,Name) VALUES (30,"Description","Body of Sternum");
INSERT INTO BonePart (Bone_idBone,Description,Name) VALUES (30,"Description","Xiphoid Process");


INSERT INTO BoneSet(BoneSet_idParent,Category,Description,Synonymous,BoneNumber) VALUES (9,"Rib Cage","Description","Thoracic Cage",24);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,Synonymous,BoneNumber) VALUES (10,"Vertebrosternal Ribs","Description","True Ribs",24);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (10,"False Ribs","Description",10);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,Synonymous,BoneNumber) VALUES (11,"Right Vertebrosternal Ribs","Description","Right True Ribs",12);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,Synonymous,BoneNumber) VALUES (11,"Left Vertebrosternal Ribs","Description","Left True Ribs",12);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,Synonymous,BoneNumber) VALUES (12,"Right False Ribs","Description","Right True Ribs",13);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,Synonymous,BoneNumber) VALUES (12,"Left False Ribs","Description","Left True Ribs",13);

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (13,"Description","Right 01 Rib");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (13,"Description","Right 02 Rib");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (13,"Description","Right 03 Rib");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (13,"Description","Right 04 Rib");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (13,"Description","Right 05 Rib");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (13,"Description","Right 06 Rib");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (13,"Description","Right 07 Rib");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (14,"Description","Left 01 Rib");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (14,"Description","Left 02 Rib");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (14,"Description","Left 03 Rib");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (14,"Description","Left 04 Rib");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (14,"Description","Left 05 Rib");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (14,"Description","Left 06 Rib");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (14,"Description","Left 07 Rib");


INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (16,"Left Vertebrochondal Rib","Description",3);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (15,"Right Vertebrochondal Rib","Description",3);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (16,"Left Floating Rib","Description",2);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (15,"Right Floating  Rib","Description",2);

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (18,"Description","Right 08 Rib");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (18,"Description","Right 09 Rib");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (18,"Description","Right 10 Rib");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (17,"Description","Left 08 Rib");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (17,"Description","Left 09 Rib");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (17,"Description","Left 10 Rib");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (20,"Description","Right 11 Rib");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (20,"Description","Right 12 Rib");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (19,"Description","Left 11 Rib");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (19,"Description","Left 12 Rib");

INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (9,"Vertebral Column","Description",26);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (21,"Cervical Spine","Description",7);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (21,"Lumbar Spine","Description",5);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (21,"Thoracic Spine","Description",12);
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (21,"Description","Sacral Spine");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (21,"Description","Coccygeal Spine");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (22,"Description","C1 Atlas");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (22,"Description","C2 Axis");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (22,"Description","C3 Vertebra");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (22,"Description","C4 Vertebra");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (22,"Description","C5 Vertebra");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (22,"Description","C6 Vertebra");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (22,"Description","C7 Vertebra");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (23,"Description","T01 Vertebra");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (23,"Description","T02 Vertebra");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (23,"Description","T03 Vertebra");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (23,"Description","T04 Vertebra");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (23,"Description","T05 Vertebra");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (23,"Description","T06 Vertebra");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (23,"Description","T07 Vertebra");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (23,"Description","T08 Vertebra");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (23,"Description","T09 Vertebra");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (23,"Description","T10 Vertebra");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (23,"Description","T11 Vertebra");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (23,"Description","T12 Vertebra");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (24,"Description","L1 Vertebra");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (24,"Description","L2 Vertebra");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (24,"Description","L3 Vertebra");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (24,"Description","L4 Vertebra");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (24,"Description","L5 Vertebra");

INSERT INTO BonePart (Bone_idBone,Description,Name) VALUES (61,"Description","S1 Vertebra");
INSERT INTO BonePart (Bone_idBone,Description,Name) VALUES (61,"Description","S2 Vertebra");
INSERT INTO BonePart (Bone_idBone,Description,Name) VALUES (61,"Description","S3 Vertebra");
INSERT INTO BonePart (Bone_idBone,Description,Name) VALUES (61,"Description","S4 Vertebra");
INSERT INTO BonePart (Bone_idBone,Description,Name) VALUES (61,"Description","S5 Vertebra");
INSERT INTO BonePart (Bone_idBone,Description,Name,Synonymous) VALUES (62,"Four fused bones","Coccyx","Tailbone");

/*----- */

INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (1,"Appendicular","Description",126);

INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber,Synonymous) VALUES (25,"Shoulder Girdle","Description",4,"Pectoral Girdle");
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber,Synonymous) VALUES (26,"Left Shoulder Girdle","Description",2,"Left Pectoral Girdle");
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber,Synonymous) VALUES (26,"Right Shoulder Girdle","Description",2,"Right Pectoral Girdle");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (27,"Description","Left Scapula");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (27,"Description","Left Cavicle");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (28,"Description","Right Scapula");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (28,"Description","Right Cavicle");


INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (25,"Pelvic Girdle","Description",2);
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name,Synonymous) VALUES (29,"Description","Left Hip Bone","Left Coxal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name,Synonymous) VALUES (29,"Description","Right Hip Bone","Right Coxal");
INSERT INTO BonePart (Bone_idBone,Description,Name) VALUES (85,"Description","Left Ilium");
INSERT INTO BonePart (Bone_idBone,Description,Name) VALUES (85,"Description","Left Publis");
INSERT INTO BonePart (Bone_idBone,Description,Name) VALUES (85,"Description","Left Ischium");
INSERT INTO BonePart (Bone_idBone,Description,Name) VALUES (86,"Description","Right Ilium");
INSERT INTO BonePart (Bone_idBone,Description,Name) VALUES (86,"Description","Right Publis");
INSERT INTO BonePart (Bone_idBone,Description,Name) VALUES (86,"Description","Right Ischium");



INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (25,"Lower Limb","Description",60);

INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (31,"Left Lower Limb","Description",30);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (31,"Right Lower Limb","Description",30);

INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (32,"Left Leg","Description",2);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (33,"Right Leg","Description",2);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (32,"Left Foot","Description",26);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (33,"Right Foot","Description",26);

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name,Synonymous) VALUES (32,"Description","Left Femur","Left Thigh");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name,Synonymous) VALUES (32,"Description","Left Patella","Left Knee Cap");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name,Synonymous) VALUES (33,"Description","Right Femur","Right Thigh");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name,Synonymous) VALUES (33,"Description","Right Patella","Right Knee Cap");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (34,"Description","Left Tibia");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (34,"Description","Left Fibula");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (35,"Description","Right Tibia");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (35,"Description","Right Fibula");

INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (36,"Left Tarsus","Description",7);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (37,"Right Tarsus","Description",7);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (36,"Left Metatarsus","Description",5);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (37,"Right Metatarsus","Description",5);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (36,"Left Foot Phalanges","Description",14);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (37,"Right Foot Phalanges","Description",14);

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (38,"Description","Left Calcaneus");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (38,"Description","Left Talus");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (38,"Description","Left Navicular");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (38,"Description","Left Cuboid");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (38,"Description","Left Lateral Cuneiform");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (38,"Description","Left Intermediate Cuneiform");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (38,"Description","Left Medial Cuneiform");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (39,"Description","Right Calcaneus");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (39,"Description","Right Talus");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (39,"Description","Right Navicular");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (39,"Description","Right Cuboid");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (39,"Description","Right Lateral Cuneiform");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (39,"Description","Right Intermediate Cuneiform");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (39,"Description","Right Medial Cuneiform");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (40,"Description","Left 1 Metatarsal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (40,"Description","Left 2 Metatarsal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (40,"Description","Left 3 Metatarsal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (40,"Description","Left 4 Metatarsal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (40,"Description","Left 5 Metatarsal");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (41,"Description","Right 1 Metatarsal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (41,"Description","Right 2 Metatarsal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (41,"Description","Right 3 Metatarsal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (41,"Description","Right 4 Metatarsal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (41,"Description","Right 5 Metatarsal");


INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (42,"Description","Left 1 Foot Proximal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (42,"Description","Left 2 Foot Proximal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (42,"Description","Left 3 Foot Proximal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (42,"Description","Left 4 Foot Proximal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (42,"Description","Left 5 Foot Proximal Phalanx");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (43,"Description","Right 1 Foot Proximal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (43,"Description","Right 2 Foot Proximal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (43,"Description","Right 3 Foot Proximal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (43,"Description","Right 4 Foot Proximal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (43,"Description","Right 5 Foot Proximal Phalanx");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (42,"Description","Left 1 Foot Middle Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (42,"Description","Left 2 Foot Middle Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (42,"Description","Left 3 Foot Middle Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (42,"Description","Left 4 Foot Middle Phalanx");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (43,"Description","Right 1 Foot Middle Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (43,"Description","Right 2 Foot Middle Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (43,"Description","Right 3 Foot Middle Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (43,"Description","Right 4 Foot Middle Phalanx");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (42,"Description","Left 1 Foot Distal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (42,"Description","Left 2 Foot Distal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (42,"Description","Left 3 Foot Distal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (42,"Description","Left 4 Foot Distal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (42,"Description","Left 5 Foot Distal Phalanx");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (43,"Description","Right 1 Foot Distal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (43,"Description","Right 2 Foot Distal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (43,"Description","Right 3 Foot Distal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (43,"Description","Right 4 Foot Distal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (43,"Description","Right 5 Foot Distal Phalanx");




INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (25,"Upper Limb","Description",60);

INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (43,"Left Upper Limb","Description",30);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (43,"Right Upper Limb","Description",30);

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name,Synonymous) VALUES (44,"Description","Left Humerus","Arm");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name,Synonymous) VALUES (45,"Description","Right Humerus","Arm");

INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (44,"Left Forearm","Description",2);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (45,"Right Forearm","Description",2);

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (44,"Description","Left Ulna");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (45,"Description","Right Ulna");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (44,"Description","Left Radius");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (45,"Description","Right Radius");

INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (44,"Left Hand","Description",27); 
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (45,"Right Hand","Description",27); 


INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (48,"Left Carpus","Description",8);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (49,"Right Carpus","Description",8);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (48,"Left Metacarpus","Description",5);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (49,"Right Metacarpus","Description",5);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (48,"Left Hand Phalanges","Description",15);
INSERT INTO BoneSet(BoneSet_idParent,Category,Description,BoneNumber) VALUES (49,"Right Hand Phalanges","Description",15);

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (50,"Description","Left Lunate");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (50,"Description","Left Scaphoid");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (50,"Description","Left Triquetral");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (50,"Description","Left Capitate");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (50,"Description","Left Hamate");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (50,"Description","Left Pisiform");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (50,"Description","Left Trapezoid");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (50,"Description","Left Trapezium");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (51,"Description","Right Lunate");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (51,"Description","Right Scaphoid");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (51,"Description","Right Triquetral");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (51,"Description","Right Capitate");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (51,"Description","Right Hamate");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (51,"Description","Right Pisiform");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (51,"Description","Right Trapezoid");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (51,"Description","Right Trapezium");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (52,"Description","Left 1 Metacarpal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (52,"Description","Left 2 Metacarpal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (52,"Description","Left 3 Metacarpal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (52,"Description","Left 4 Metacarpal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (52,"Description","Left 5 Metacarpal");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (53,"Description","Right 1 Metacarpal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (53,"Description","Right 2 Metacarpal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (53,"Description","Right 3 Metacarpal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (53,"Description","Right 4 Metacarpal");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (53,"Description","Right 5 Metacarpal");


INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (54,"Description","Left 1 Hand Proximal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (54,"Description","Left 2 Hand Proximal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (54,"Description","Left 3 Hand Proximal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (54,"Description","Left 4 Hand Proximal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (54,"Description","Left 5 Hand Proximal Phalanx");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (55,"Description","Right 1 Hand Proximal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (55,"Description","Right 2 Hand Proximal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (55,"Description","Right 3 Hand Proximal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (55,"Description","Right 4 Hand Proximal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (55,"Description","Right 5 Hand Proximal Phalanx");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (54,"Description","Left 1 Hand Middle Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (54,"Description","Left 2 Hand Middle Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (54,"Description","Left 3 Hand Middle Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (54,"Description","Left 4 Hand Middle Phalanx");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (55,"Description","Right 1 Hand Middle Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (55,"Description","Right 2 Hand Middle Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (55,"Description","Right 3 Hand Middle Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (55,"Description","Right 4 Hand Middle Phalanx");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (54,"Description","Left 1 Hand Distal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (54,"Description","Left 2 Hand Distal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (54,"Description","Left 3 Hand Distal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (54,"Description","Left 4 Hand Distal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (54,"Description","Left 5 Hand Distal Phalanx");

INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (55,"Description","Right 1 Hand Distal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (55,"Description","Right 2 Hand Distal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (55,"Description","Right 3 Hand Distal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (55,"Description","Right 4 Hand Distal Phalanx");
INSERT INTO Bone (BoneSet_idBoneSet,Description,Name) VALUES (55,"Description","Right 5 Hand Distal Phalanx");


INSERT INTO BoneSet(BoneSet_idParent,Category,Description) VALUES (NULL,"Teeth","Description");


SELECT b1.idBoneSet, b2.Name FROM BoneSet AS b1 
INNER JOIN Bone AS b2 
ON b1.idBoneSet = b2.BoneSet_idBoneSet
WHERE b1.Category LIKE "Cranium";

SELECT count(*) FROM BoneSet WHERE BoneSet_idParent=3;
SELECT * FROM Bone;
SELECT * FROM BoneSet WHERE Category = "Upper Limb";
SELECT * FROM BoneSet WHERE idBoneSet > 40;
SELECT * FROM Bone WHERE BoneSet_idBoneSet = 29;

